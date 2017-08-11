package vn.vcc.adopt.server.sparkserver.core;

import spark.Request;
import spark.Response;
import spark.Route;
import vn.vcc.adopt.tools.Tool;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SparkServer implements Route {
	// luu cac chunk du lieu
	private static Map<Integer, byte[]> mapper;
	// thoi gian
	private static long timestamp;
	// vi tri bat dau cua cac chunk
	private static List<Integer> begin;
	// size cua du lieu
	private static int total;
	// ten class
	private static String className;
	/**
	 * Contructor SaveObject
	 */
	public SparkServer(){
		mapper = new ConcurrentHashMap<Integer, byte[]>();
		begin = new ArrayList<>();
	}

	/**
     * tao server nhan request
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
	public Object handle(Request request, Response response) throws Exception {
		System.out.println("Nhan duoc request");
		int type = Integer.parseInt(request.queryParams("type"));

		//neu type = 1 thi tra ve:
		// + so luong chunk - mapper.size()
		// + do dai cua du lieu - total
		// + thoi gian cap nhat lan cuoi - timestamp
		if (type == 1) {
			return getMapper().size()+ "-"+total+ "-" + timestamp+"-" + className;
		}
		//neu type = 2 thi tra ve chunk tuong ung voi stt gui len
		else if(type == 2){
            int index = Integer.parseInt(request.queryParams("stt"));
			byte[] data = getMapper().get(index);
			String body = Tool.genData(begin.get(index), data);
			return body;
		}
		//neu type = 3 tra ve timestamp
		else{
			return  timestamp;
		}

	}

	// Getter va Setter
	public synchronized static Map<Integer, byte[]> getMapper() {
		return mapper;
	}

	public static void setMapper(Map<Integer, byte[]> mapper) {
		SparkServer.mapper = mapper;
	}

	public static long getTimestamp() {
		return timestamp;
	}

	public static void setTimestamp(long timestamp) {
		SparkServer.timestamp = timestamp;
	}

	public static List<Integer> getBegin() {
		return begin;
	}

	public static void setBegin(List<Integer> begin) {
		SparkServer.begin = begin;
	}

	public static int getTotal() {
		return total;
	}

	public static void setTotal(int total) {
		SparkServer.total = total;
	}

	public static String getClassName() {
		return className;
	}

	public static void setClassName(String className) {
		SparkServer.className = className;
	}

}
