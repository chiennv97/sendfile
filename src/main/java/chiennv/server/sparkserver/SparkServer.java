package chiennv.server.sparkserver;

import spark.Request;
import spark.Response;
import spark.Route;
import chiennv.server.model.Data;
import chiennv.tools.Tool;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.zip.GZIPOutputStream;

public class SparkServer implements Route {

	private Data data;
	
	public SparkServer(Data data){
		this.data = data;
	}

	public Object handle(Request request, Response response) throws Exception {
		// TODO Auto-generated method stub
		if (request.requestMethod().equals("HEAD")) {
			int numberOfObject = data.getNumberOfObject();
			String listNameObject = "";
			String listLengthObject = "";
			for(String key : data.getData().keySet()){
				listNameObject += key+"-";
				listLengthObject += data.getData().get(key).length+"-";
			}
			response.header("ListNameObject", listNameObject);
			response.header("ListLengthObject", listLengthObject);
			response.header("NumberOfObject", numberOfObject + "");
			response.header("ETag", data.getTimestamp()+"");
			return response;
		}
 		else {
			String range = request.headers("Range");
			String nameObject = request.headers("NameObject");
			byte[] dataObj = data.getData().get(nameObject);
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
