package vn.vcc.adopt.client;

import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.util.FutureResponseListener;

import vn.vcc.adopt.tools.Tool;

public class GetChunkThread implements Runnable {
	private ReceivedObject ro;
	private int start;
	private int end;
	private String url;
	private String nameObj1;
	private String nameObj2;
	private int selectNameObj;

	public GetChunkThread(int start, int end, ReceivedObject ro, String url, String nameObj1, String nameObj2, int selectNameObj) {
		this.start = start;
		this.end = end;
		this.ro = ro;
		this.url = url;
		this.nameObj1 = nameObj1;
		this.nameObj2 = nameObj2;
		this.selectNameObj = selectNameObj;
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			HttpClient httpClient = new HttpClient();
			httpClient.start();
			boolean success = false;
			while (!success) {
				String nameObj;
				if(selectNameObj == 1){
					nameObj = nameObj1;
				}else{
					nameObj = nameObj2;
				}
				Request request = httpClient.newRequest(url)
						.header("Range","bytes=" + start + "-" + end)
						.header("NameObject", nameObj);
				FutureResponseListener listener = new FutureResponseListener(request, 100 * 1024 * 1024);
				request.send(listener);
				ContentResponse response = listener.get(300, TimeUnit.SECONDS);
				String checksum = response.getHeaders().get("Checksum");
				byte[] decompressed = Tool.unGzip(response.getContent());
				if (Tool.calChecksum(decompressed).equals(checksum)) {
					if(selectNameObj == 1){
						System.arraycopy(decompressed, 0, ro.getDataObj1(), start, end - start + 1);
						success = true;
					}else {
						System.arraycopy(decompressed, 0, ro.getDataObj2(), start, end - start + 1);
						success = true;
					}

				}
			}

			httpClient.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	

}
