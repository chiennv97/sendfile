package vn.vcc.adopt.server.model;

import java.io.Serializable;

/**
 * Created by chiennv on 14/08/2017.
 */
public class Data implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private byte[] data;
	// thoi gian
	private long timestamp;

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

}
