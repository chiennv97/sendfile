package vn.vcc.adopt.client;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by chiennv on 30/08/2017.
 */
public class GetOneObject implements Runnable {
    private int length;
    private ReceivedObject ro;
    private String url;
    private String nameObj1;
    private String nameObj2;
    private int selectNameObj;

    public GetOneObject(int length, ReceivedObject ro, String url, String nameObj1, String nameObj2, int selectNameObj){
        this.length = length;
        this.ro = ro;
        this.url = url;
        this.nameObj1 = nameObj1;
        this.nameObj2 = nameObj2;
        this.selectNameObj = selectNameObj;
    }
    @Override
    public void run() {

        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < length; i += 10485760) {
            es.execute(new GetChunkThread(i, Math.min(i + 10485759, length - 1), ro, url, nameObj1, nameObj2, selectNameObj));
        }
        es.shutdown();
        try {
            while (!es.awaitTermination(5, TimeUnit.MINUTES));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
