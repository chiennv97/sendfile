package vn.vcc.adopt.client;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.SerializationUtils;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.util.FutureResponseListener;
import org.eclipse.jetty.http.HttpFields;

public class GetData {
	public static long timestamp = 0;

	public static ReceivedObject getNewData(String url) throws Exception {
		long t1 = System.currentTimeMillis();
		HttpClient httpClient = new HttpClient();
		httpClient.start();
		Request request = httpClient.newRequest(url).method("HEAD");
		FutureResponseListener listener = new FutureResponseListener(request, 300 * 1024 * 1024);
		request.send(listener);
		ContentResponse response = listener.get(60, TimeUnit.SECONDS);

		HttpFields headers = response.getHeaders();
		int lengthObj1 = Integer.parseInt(headers.getField("LengthObject1").getValue());
		int lengthObj2 = Integer.parseInt(headers.getField("LengthObject2").getValue());
		String nameObj1 = headers.getField("NameObject1").getValue();
		String nameObj2 = headers.getField("NameObject2").getValue();
		System.out.println(lengthObj1);
		System.out.println(lengthObj2);
		long etag = Long.parseLong(headers.getField("ETag").getValue());
		if (timestamp != etag) {
			timestamp = etag;
			ReceivedObject ro = new ReceivedObject(lengthObj1, lengthObj2, nameObj1, nameObj2);
			ExecutorService es = Executors.newFixedThreadPool(2);
			es.execute(new GetOneObject(lengthObj1, ro, url, nameObj1, nameObj2, 1));
			es.execute(new GetOneObject(lengthObj2, ro, url, nameObj1, nameObj2, 2));
			es.shutdown();
			while (!es.awaitTermination(5, TimeUnit.MINUTES));
			httpClient.stop();
			System.out.println("Time: " + (System.currentTimeMillis() - t1));
			return ro;
		} else {
			System.out.println("Khong co phien ban moi");
			httpClient.stop();
			return null;
		}
	}
}
