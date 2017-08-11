package vn.vcc.adopt.client;

public class ReceivedObject {

	private byte[] rawData;
	private int chunksReceived;
	private int number_of_chunks;
	private String class_name;

	public ReceivedObject(int total, int number_of_chunks, String className){
		rawData = new byte[total];
		this.number_of_chunks = number_of_chunks;
		chunksReceived = 0;
		class_name = className;
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

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}
}
