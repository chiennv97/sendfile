package vn.vcc.adopt.client;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.util.FutureResponseListener;
import vn.vcc.adopt.tools.Tool;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class GetChunkThread implements Runnable {
	private HttpClient httpClient;
	private ReceivedObject rObj;
	private int stt;
	private String url;

	public GetChunkThread(HttpClient httpClient, ReceivedObject rObj, int stt, String url) {
		this.httpClient = httpClient;
		this.rObj = rObj;
		this.stt = stt;
		this.url = url;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		boolean success = false;
//		while (!success) {
		Request request = httpClient.newRequest(url +"?type=2&stt=" + stt);

		FutureResponseListener listener = new FutureResponseListener(request, 20 * 1024 * 1024);

		request.send(listener);

		try {
			ContentResponse response = listener.get(20, TimeUnit.SECONDS);
			long t2 = System.currentTimeMillis();
			Chunk chunk = new ObjectMapper().readValue(response.getContentAsString(), Chunk.class);
			System.out.println("Thoi gian nhan request type 2: "+(System.currentTimeMillis()-t2));
			t2 = System.currentTimeMillis();
			byte[] data = Base64.getDecoder().decode(chunk.getData());
			System.out.println("Thoi gian decode: "+ (System.currentTimeMillis()-t2));
			if (chunk.getChecksum().equals(Tool.calChecksum(data))) {
				data = Tool.unGzip(data);
//				success = true;
				System.arraycopy(data, 0, rObj.getRawData(), chunk.getBegin(), data.length);
				rObj.setChunksReceived(rObj.getChunksReceived() + 1);
			}
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (TimeoutException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//			httpClient.newRequest("http://localhost:9999/getdata?type=2&stt=" + stt)
//					.send(new BufferingResponseListener(20 * 1024 * 1024) {
//						@Override
//						public void onComplete(Result result) {
//							try {
//								if (!result.isFailed()) {
//									Chunk chunk = new ObjectMapper().readValue(getContentAsString(), Chunk.class);
//									byte[] data = Base64.getDecoder().decode(chunk.getData());
//									if (chunk.getChecksum().equals(Tool.calChecksum(data))) {
//										data = Tool.unGzip(data);
////										success = true;
//										System.arraycopy(data, 0, rObj.getRawData(), chunk.getBegin(), data.length);
//										rObj.setChunksReceived(rObj.getChunksReceived() + 1);
//									}
//									System.out.println("Nhan duoc response");
//								} else{
//									System.out.println("Fail");
//								}
//							} catch (Exception ex) {
//								ex.printStackTrace();
//							}
//						}
//					});
//		}
//			try {
//				Thread.sleep(20000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	}

}
