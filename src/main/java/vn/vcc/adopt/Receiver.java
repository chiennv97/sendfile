package vn.vcc.adopt;

import org.apache.commons.lang3.SerializationUtils;
import vn.vcc.adopt.client.GetData;
import vn.vcc.adopt.client.ListReceivedObject;

import java.util.HashMap;

public class Receiver {
    public static void main(String[] args) throws Exception {
        HashMap model1;
        for(int i=0; i<30; i++){
            System.out.println("get");
            ListReceivedObject listReceivedObj = GetData.getNewData("http://192.168.23.215:14567/getdata");
            System.out.println(listReceivedObj.getListData().get("bannersgoogle"));
            if(listReceivedObj.getListData().get("bannersgoogle")!= null){
                model1 = SerializationUtils.deserialize(listReceivedObj.getListData().get("bannersgoogle").getData());
                System.out.println(model1.size());
            }
            Thread.sleep(15000);
        }
    }
}
//35851384
//566776ad