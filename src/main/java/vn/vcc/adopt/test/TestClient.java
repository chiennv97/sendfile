package vn.vcc.adopt.test;

import org.apache.commons.lang3.SerializationUtils;

import vn.vcc.adopt.client.GetData;
import vn.vcc.adopt.client.ReceivedObject;

public class TestClient {
	public static void main(String[] args) {
		try {
			ReceivedObject receivedObj = GetData.getNewData("http://localhost:9999/getdata");
			Model model = SerializationUtils.deserialize(receivedObj.getData());
			System.out.println(model.getId());
//			Thread.sleep(10000);
//			receivedObj = GetData.getNewData("http://192.168.23.59:9999/getdata");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
