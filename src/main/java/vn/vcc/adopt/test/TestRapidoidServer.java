package vn.vcc.adopt.test;

import org.rapidoid.setup.On;

import vn.vcc.adopt.server.core.SaveObject;
import vn.vcc.adopt.server.model.Data;
import vn.vcc.adopt.server.rapidoid.RapidoidServer;

public class TestRapidoidServer {
	public static void main(String[] args) {
		Data data = new Data();
		MapData.Map("data.json");
		SaveObject.saveObject(data, MapData.model);
		On.port(9999);
		On.head("/getdata").plain(new RapidoidServer(data));
		On.get("/getdata").plain(new RapidoidServer(data));
	}
}
