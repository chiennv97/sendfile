package vn.vcc.adopt.client;

public class ReceivedObject {
	private byte[] dataObj1;
	private byte[] dataObj2;
	private int chunkReceivedObj1;
	private int chunkReceivedObj2;
	private int totalObj1;
	private int totalObj2;
	private String nameObj1;
	private String nameObj2;

	public ReceivedObject(int totalBytesObj1, int totalBytesObj2, String nameObj1, String nameObj2){
		dataObj1 = new byte[totalBytesObj1];
		dataObj2 = new byte[totalBytesObj2];
		chunkReceivedObj1 = 0;
		chunkReceivedObj2 = 0;
		this.nameObj1 = nameObj1;
		this.nameObj2 = nameObj2;
	}
	public byte[] getObjByName(String nameObj){
		if(nameObj.equals(nameObj1)){
			return dataObj1;
		}
		else if(nameObj.equals(nameObj2)){
			return dataObj2;
		}
		return null;
	}
	public byte[] getDataObj1() {
		return dataObj1;
	}

	public String getNameObj1() {
		return nameObj1;
	}

	public void setNameObj1(String nameObj1) {
		this.nameObj1 = nameObj1;
	}

	public String getNameObj2() {
		return nameObj2;
	}

	public void setNameObj2(String nameObj2) {
		this.nameObj2 = nameObj2;
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

	public int getChunkReceivedObj1() {
		return chunkReceivedObj1;
	}

	public void setChunkReceivedObj1(int chunkReceivedObj1) {
		this.chunkReceivedObj1 = chunkReceivedObj1;
	}

	public int getChunkReceivedObj2() {
		return chunkReceivedObj2;
	}

	public void setChunkReceivedObj2(int chunkReceivedObj2) {
		this.chunkReceivedObj2 = chunkReceivedObj2;
	}

	public int getTotalObj1() {
		return totalObj1;
	}

	public void setTotalObj1(int totalObj1) {
		this.totalObj1 = totalObj1;
	}

	public int getTotalObj2() {
		return totalObj2;
	}

	public void setTotalObj2(int totalObj2) {
		this.totalObj2 = totalObj2;
	}
	//	public byte[] getData() {
//		return data;
//	}
//
//	public void setData(byte[] data) {
//		this.data = data;
//	}
//
//	public int getChunkReceived() {
//		return chunkReceived;
//	}
//
//	public void setChunkReceived(int chunkReceived) {
//		this.chunkReceived = chunkReceived;
//	}
//
//	public int getTotal() {
//		return total;
//	}
//
//	public void setTotal(int total) {
//		this.total = total;
//	}
	
	
}
