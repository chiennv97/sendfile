package vn.vcc.adopt.client;

public class ReceivedObject {
	private byte[] data;
	private int chunkReceived;
	private int total;
	
	public ReceivedObject(int totalBytes){
		data = new byte[totalBytes];
		chunkReceived = 0;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public int getChunkReceived() {
		return chunkReceived;
	}

	public void setChunkReceived(int chunkReceived) {
		this.chunkReceived = chunkReceived;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
