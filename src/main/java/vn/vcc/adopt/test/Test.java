package vn.vcc.adopt.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.util.FutureResponseListener;

import spark.utils.IOUtils;

public class Test {
	public static void main(String[] args) {
		try {
			long t0 = System.currentTimeMillis();
			HttpClient httpClient = new HttpClient();
			httpClient.start();
			Request request = httpClient.newRequest("http://192.168.23.59:9999/getdata");
			FutureResponseListener listener = new FutureResponseListener(request,300*1024*1024);
			request.send(listener);
			ContentResponse response = listener.get(300, TimeUnit.SECONDS);
			long t1 = System.currentTimeMillis();
			byte[] decompressed = unGzip(response.getContent());
			RandomAccessFile raf = new RandomAccessFile(new File("data2.json"), "rw");
			raf.write(decompressed);
			raf.close();
			System.out.println("Thoi gian ghi vao file: "+(System.currentTimeMillis()-t1));
			httpClient.stop();
			System.out.println("Time: "+(System.currentTimeMillis()-t0));
			MapData.Map("data2.json");
			System.out.println(MapData.model.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static byte[] unGzip(byte[] bytes) {
		// tao byteStream va giai nen du lieu, copy vao byteStream
		try {
			ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
			ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
			GZIPInputStream gis = new GZIPInputStream(bais);
			IOUtils.copy(gis, byteStream);
			byte[] decompressedData = byteStream.toByteArray();
			bais.close();
			byteStream.close();
			gis.close();
			return decompressedData;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
}
