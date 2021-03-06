package chiennv.client;

import java.util.concurrent.TimeUnit;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.util.FutureResponseListener;

import chiennv.tools.Tool;

public class GetChunkThread implements Runnable {
	private ReceivedObject ro;
	private int start;
	private int end;
	private String url;
	private String nameObj;

	public GetChunkThread(int start, int end, ReceivedObject ro, String url, String nameObj) {
		this.start = start;
		this.end = end;
		this.ro = ro;
		this.url = url;
		this.nameObj = nameObj;
	}

	public void run() {
		// TODO Auto-generated method stub
        HttpClient httpClient = new HttpClient();
		try {
			httpClient.start();
			boolean success = false;
			while (!success) {
				Request request = httpClient.newRequest(url)
						.header("Range","bytes=" + start + "-" + end)
						.header("NameObject", nameObj);
				FutureResponseListener listener = new FutureResponseListener(request, 100 * 1024 * 1024);
				request.send(listener);
				ContentResponse response = listener.get(300, TimeUnit.SECONDS);
				String checksum = response.getHeaders().get("Checksum");
				byte[] decompressed = Tool.unGzip(response.getContent());
				if (Tool.calChecksum(decompressed).equals(checksum)) {
					System.arraycopy(decompressed, 0, ro.getData(), start, end - start + 1);
					success = true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
            try {
                httpClient.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

	}

	

}
