package chiennv.server.core;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import chiennv.server.model.Data;
import org.apache.commons.lang3.SerializationUtils;

/**
 * Created by chiennv on 10/08/2017.
 */
public class SaveObject {
    private static Data data;
    public static void saveData(Data data){
        SaveObject.data = data;
    }

    public static void saveObject( String nameObject, Object object) throws InterruptedException {
        ExecutorService es = Executors.newCachedThreadPool();
        if (!data.getData().containsKey(nameObject)) {
            data.setNumberOfObject(data.getNumberOfObject()+1);
        }
        es.execute(new Runnable() {
            @Override
            public void run() {
                data.getData().put(nameObject,(SerializationUtils.serialize((Serializable) object)));
            }
        });
        es.shutdown();
        while (!es.awaitTermination(5, TimeUnit.MINUTES));

    }
    public static void saveLastModified(){
        data.setTimestamp(System.nanoTime());
    }
    public static void removeOjbectByName(String nameObject){
        if(data.getData().containsKey(nameObject)){
            data.getData().remove(nameObject);
            if(data.getNumberOfObject() > 0){
                data.setNumberOfObject(data.getNumberOfObject()-1);
            }
            saveLastModified();
        }


    }
    public static void removeAllObject(){
        data.getData().clear();
        data.setNumberOfObject(0);
        saveLastModified();
    }
}
