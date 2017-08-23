package vn.vcc.adopt.tools;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.GZIPInputStream;

import spark.utils.IOUtils;

public class Tool {
	public static String calChecksum(byte[] bytesOfData) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(bytesOfData);
		byte[] digest = md.digest();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < digest.length; i++) {
			sb.append(Integer.toString((digest[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
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
	public static void copy(InputStream input, OutputStream output, long start, long length) throws IOException {
		byte[] buffer = new byte[10240];
		int read;
		input.skip(start);
		long toRead = length;
		while ((read = input.read(buffer)) > 0) {
			if ((toRead -= read) > 0) {
				output.write(buffer, 0, read);
			} else {
				output.write(buffer, 0, (int) toRead + read);
				break;
			}
		}
	}
}
