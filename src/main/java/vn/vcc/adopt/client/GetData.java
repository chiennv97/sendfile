package vn.vcc.adopt.client;
import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.util.FutureResponseListener;
import org.eclipse.jetty.http.HttpFields;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GetData {
	public static long timestamp;

	public static ListReceivedObject getNewData(String url) throws Exception {
		long t1 = System.currentTimeMillis();
		HttpClient httpClient = new HttpClient();
		httpClient.start();
		Request request = httpClient.newRequest(url).method("HEAD");
		FutureResponseListener listener = new FutureResponseListener(request, 300 * 1024 * 1024);
		request.send(listener);
		ContentResponse response;
		try{
			response = listener.get(60, TimeUnit.SECONDS);
		} finally {
			httpClient.stop();
		}
		HttpFields headers = response.getHeaders();

		if(headers.getField("ListNameObject") != null){
            String listNameObject = headers.getField("ListNameObject").getValue();
            String listLengthObject = headers.getField("ListLengthObject").getValue();
            long ETag = Long.parseLong(headers.getField("ETag").getValue());
            int numberOfObject = Integer.parseInt(headers.getField("NumberOfObject").getValue());
            String[] nameObject = listNameObject.split("-");
            String[] lengthObject = listLengthObject.split("-");


            ListReceivedObject listRO = new ListReceivedObject();
            ExecutorService es = Executors.newCachedThreadPool();

//            if(timestamp < ETag){
//                timestamp = ETag;
                for(int i=0; i<numberOfObject; i++){
                    int length = Integer.parseInt(lengthObject[i]);
                    ReceivedObject RO = new ReceivedObject(length);
                    es.execute(new GetOneObject(length,RO,url,nameObject[i]));
                    listRO.getListData().put(nameObject[i], RO);
                }
//            }
            es.shutdown();
            try {
                while (!es.awaitTermination(5, TimeUnit.MINUTES));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            httpClient.stop();
            return listRO;
		}

		httpClient.stop();
		return null;
	}
}
