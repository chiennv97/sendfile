package vn.vcc.adopt.client;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by chiennv on 01/09/2017.
 */
public class ListReceivedObject {
    private HashMap<String, ReceivedObject> listData;
    private int numberOfObject;
    public ListReceivedObject(){
        listData = new HashMap<String, ReceivedObject>();
    }

    public HashMap<String, ReceivedObject> getListData() {
        return listData;
    }

    public void setListData(HashMap<String, ReceivedObject> listData) {
        this.listData = listData;
    }

    public int getNumberOfObject() {
        return numberOfObject;
    }

    public void setNumberOfObject(int numberOfObject) {
        this.numberOfObject = numberOfObject;
    }
}
