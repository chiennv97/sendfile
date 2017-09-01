package vn.vcc.adopt.server.core;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.SerializationUtils;

import vn.vcc.adopt.server.model.Data;

/**
 * Created by chiennv on 10/08/2017.
 */
public class SaveObject {
    /**
     * chia object thanh cac chunk roi put vao mapper
     * @param data
     * @param object1
     * @param object2
     */
    public static void saveObject(Data data,Object object1, String nameObject1, Object object2, String nameObject2) throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute(new Runnable() {
            @Override
            public void run() {
                data.setDataObj1(SerializationUtils.serialize((Serializable) object1));
            }
        });
        es.execute(new Runnable() {
            @Override
            public void run() {
                data.setDataObj2(SerializationUtils.serialize((Serializable) object2));
            }
        });
        es.shutdown();
        while (!es.awaitTermination(5, TimeUnit.MINUTES));
        data.setNameDataObj1(nameObject1);
        data.setNameDataObj2(nameObject2);
    	data.setTimestamp(System.nanoTime());
    	System.out.println(data.getDataObj1().length);
        System.out.println(data.getDataObj2().length);

    }

}
