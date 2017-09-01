package vn.vcc.adopt.server.sparkserver;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.zip.GZIPOutputStream;

import spark.Request;
import spark.Response;
import spark.Route;
import vn.vcc.adopt.server.model.Data;
import vn.vcc.adopt.tools.Tool;

public class SparkServer implements Route {

	private Data data;
	
	public SparkServer(Data data){
		this.data = data;
	}

	public Object handle(Request request, Response response) throws Exception {
		// TODO Auto-generated method stub
		if (request.requestMethod().equals("HEAD")) {
			response.header("NameObject1", data.getNameDataObj1());
			response.header("NameObject2", data.getNameDataObj2());
			response.header("LengthObject1", data.getDataObj1().length + "");
			response.header("LengthObject2", data.getDataObj2().length + "");
			response.header("ETag", data.getTimestamp()+"");
			return response;
		} else {
			String range = request.headers("Range");
			String nameObject = request.headers("NameObject");
			byte[] dataObj;
			if(nameObject.equals(data.getNameDataObj1())){
				dataObj = data.getDataObj1();
			}else {
				dataObj= data.getDataObj2();
			}
			OutputStream output = response.raw().getOutputStream();
			InputStream input = new ByteArrayInputStream(dataObj);
			output = new GZIPOutputStream(output, 10240);
			if (range != null) {
				String[] arr1 = range.split("=");
				String[] arr2 = arr1[1].split("-");
				long start = Long.parseLong(arr2[0]);
				long end = Long.parseLong(arr2[1]);
				String checksum = Tool.calChecksum(Arrays.copyOfRange(dataObj, Integer.parseInt(start+""), Integer.parseInt((end+1)+"")));
				response.header("Checksum", checksum);
				Tool.copy(input, output, start, end - start + 1);
			} else {
				String checksum = Tool.calChecksum(Arrays.copyOfRange(dataObj, 0, dataObj.length));
				response.header("Checksum", checksum);
				Tool.copy(input, output, 0, dataObj.length);
			}
			output.close();
			return response;
		}
	}
}
