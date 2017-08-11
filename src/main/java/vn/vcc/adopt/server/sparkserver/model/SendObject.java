package vn.vcc.adopt.server.sparkserver.model;

import java.io.Serializable;

public class SendObject implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long id;
	private byte[] rawData;
	private int chunksReceived;
	private int number_of_chunks;
	private String className;
	
	public SendObject(long id, int total, int number_of_chunks, String className){
		this.id = id;
		rawData = new byte[total];
		this.number_of_chunks = number_of_chunks;
		chunksReceived = 1;
		this.className = className;
	}
	
	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public byte[] getRawData() {
		return rawData;
	}

	public void setRawData(byte[] rawData) {
		this.rawData = rawData;
	}

	public int getChunksReceived() {
		return chunksReceived;
	}

	public void setChunksReceived(int chunksReceived) {
		this.chunksReceived = chunksReceived;
	}

	public int getNumber_of_chunks() {
		return number_of_chunks;
	}

	public void setNumber_of_chunks(int number_of_chunks) {
		this.number_of_chunks = number_of_chunks;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
	
}
