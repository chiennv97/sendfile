package vn.vcc.adopt.client;

public class ReceivedObject {
	private byte[] data;

	public ReceivedObject(int length){
		data = new byte[length];
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
}
