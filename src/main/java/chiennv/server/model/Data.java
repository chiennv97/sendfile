package chiennv.server.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by chiennv on 14/08/2017.
 */
public class Data implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private HashMap<String,byte[]> data;

	private int numberOfObject;

	// thoi gian
	private long timestamp;

	public Data(){
		data = new HashMap<String, byte[]>();
		numberOfObject = 0;
	}

	public HashMap<String, byte[]> getData() {
		return data;
	}

	public void setData(HashMap<String, byte[]> data) {
		this.data = data;
	}

	public int getNumberOfObject() {
		return numberOfObject;
	}

	public void setNumberOfObject(int numberOfObject) {
		this.numberOfObject = numberOfObject;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}
