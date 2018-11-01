package chiennv;

import org.apache.commons.lang3.SerializationUtils;
import chiennv.client.GetData;
import chiennv.client.ListReceivedObject;

import java.util.HashMap;

public class Receiver {
    public static void main(String[] args) throws Exception {
        HashMap model1;
        for(int i=0; i<30; i++){
            System.out.println("get");
            ListReceivedObject listReceivedObj = GetData.getNewData("http://localhost:9999/getdata");
            System.out.println(listReceivedObj.getListData().get("a"));
            if(listReceivedObj.getListData().get("a")!= null){
                model1 = SerializationUtils.deserialize(listReceivedObj.getListData().get("a").getData());
                System.out.println(model1.size());
            }
            Thread.sleep(15000);
        }
    }
}
//35851384
//566776ad
