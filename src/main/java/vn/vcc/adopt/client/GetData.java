package vn.vcc.adopt.client;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class GetData {
    // Timestamp cua file tren client
    public static long timestamp = 0;

    /**
     * tra ve du lieu
     */
    public static ReceivedObject getData(String url) throws Exception {

        HttpClient httpClient = new HttpClient();
        httpClient.start();
        //request type 1
        long t1 = System.currentTimeMillis();
        ContentResponse response = httpClient.GET(url + "?type=1");
        System.out.println("Thoi gian request dau: " + (System.currentTimeMillis() - t1));
        System.out.println(response.getContentAsString());

        //chuan bi cho request type 2
        String[] strArr = response.getContentAsString().split("-");
        timestamp = Long.parseLong(strArr[2]);
        ReceivedObject receivedObject = new ReceivedObject(Integer.parseInt(strArr[1]), Integer.parseInt(strArr[0]), strArr[3]);

        //request type 2
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < Integer.parseInt(strArr[0]); i++) {
            es.execute(new GetChunkThread(httpClient, receivedObject, i, url));
        }
        es.shutdown();
        while (!es.awaitTermination(1, TimeUnit.MINUTES)) ;
        System.out.println("Thoi gian tinh xong het: " + (System.currentTimeMillis() - t1));
        httpClient.stop();
        return receivedObject;
    }

    /**
     * Tra ve timestamp cua file tren server
     *
     * @return
     */
    private static long getLastTime(String url) {
        long lastTime;
        try {
            HttpClient httpClient = new HttpClient();
            httpClient.start();
            ContentResponse response = httpClient.GET(url + "?type=3");
            String lastTimeString = response.getContentAsString();
            lastTime = Long.parseLong(lastTimeString);
            httpClient.stop();

            return lastTime;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Long.parseLong(null);
    }

    /**
     * Check timestamp cua file o server (timestampServer) va timestamp cua file o client (timestapClient)
     * Neu khac nhau thi tra ve file ReceiveObject
     * Neu giong nhau thi tra ve null
     */
    public static ReceivedObject getNewData(String url) throws Exception {
        long timestampServer = getLastTime(url);
        long timestampClient = timestamp;
        if (timestampServer != timestampClient) {
            return getData(url);
        }
        return null;
    }

    public static long getTimestamp() {
        return timestamp;
    }

    public static void setTimestamp(long timestamp) {
        GetData.timestamp = timestamp;
    }

}
