package vn.vcc.adopt;

import vn.vcc.adopt.server.core.SaveObject;
import vn.vcc.adopt.server.model.Data;
import vn.vcc.adopt.server.sparkserver.SparkServer;

import java.util.HashMap;
import static spark.Spark.*;
public class Sender {
    public static void main(String[] args) throws Exception {
        HashMap<Integer,String> hm=new HashMap<Integer,String>();
        hm.put(100,"Amit");
        hm.put(101,"Vijay");
        hm.put(102,"Rahul");
        Data data = new Data();
        SaveObject.saveData(data);
        SaveObject.saveObject("a", hm);
        // Lưu thời gian
        SaveObject.saveLastModified();
        port(9999);
        head("/getdata",new SparkServer(data));
        get("/getdata",new SparkServer(data));
        Thread.sleep(10000);
        System.out.println("save lai");
        hm.put(103,"abc");
        hm.put(104,"abc");
        hm.put(105,"abc");
        SaveObject.saveObject("a", hm);
        SaveObject.saveLastModified();
    }
}
