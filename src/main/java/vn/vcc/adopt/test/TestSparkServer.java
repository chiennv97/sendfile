package vn.vcc.adopt.test;

import static spark.Spark.get;
import static spark.Spark.head;
import static spark.Spark.port;

import vn.vcc.adopt.server.core.SaveObject;
import vn.vcc.adopt.server.model.Data;
import vn.vcc.adopt.server.sparkserver.SparkServer;

public class TestSparkServer {
	public static void main(String[] args) {
		port(9999);
		Data data = new Data();
		MapData.Map("data.json");
		SaveObject.saveObject(data, MapData.model);
		head("/getdata",new SparkServer(data));
		get("/getdata",new SparkServer(data));
	}
}
