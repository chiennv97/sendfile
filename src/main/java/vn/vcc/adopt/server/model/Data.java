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
	
	private byte[] dataObj1;
	private byte[] dataObj2;
	private String nameDataObj1;
	private String nameDataObj2;

	// thoi gian
	private long timestamp;

	public byte[] getDataObj1() {
		return dataObj1;
	}

	public void setDataObj1(byte[] dataObj1) {
		this.dataObj1 = dataObj1;
	}

	public byte[] getDataObj2() {
		return dataObj2;
	}

	public void setDataObj2(byte[] dataObj2) {
		this.dataObj2 = dataObj2;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getNameDataObj1() {
		return nameDataObj1;
	}

	public void setNameDataObj1(String nameDataObj1) {
		this.nameDataObj1 = nameDataObj1;
	}

	public String getNameDataObj2() {
		return nameDataObj2;
	}

	public void setNameDataObj2(String nameDataObj2) {
		this.nameDataObj2 = nameDataObj2;
	}

	//	public byte[] getData() {
//		return data;
//	}
//
//	public void setData(byte[] data) {

//		this.data = data;
//	}
//
//	public long getTimestamp() {
//		return timestamp;
//	}
//
//	public void setTimestamp(long timestamp) {
//		this.timestamp = timestamp;
//	}

}
