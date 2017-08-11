package vn.vcc.adopt.tools;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterInputStream;

import org.json.simple.JSONObject;

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

	public static byte[] gzip(byte[] bytes) throws IOException {
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream(bytes.length);
		GZIPOutputStream zipStream = new GZIPOutputStream(byteStream);
		zipStream.write(bytes);
		zipStream.close();
		byteStream.close();
		byte[] compressData = byteStream.toByteArray();
		return compressData;
	}

	public static byte[] unGzip(byte[] bytes) {
		// tao byteStream va giai nen du lieu, copy vao byteStream
		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		try {
			IOUtils.copy(new GZIPInputStream(new ByteArrayInputStream(bytes)), byteStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] decompressData = byteStream.toByteArray();
		return decompressData;
	}

	public static String genData(int begin, byte[] data) throws NoSuchAlgorithmException {
		JSONObject obj = new JSONObject();
		obj.put("begin", begin);
		obj.put("checksum", calChecksum(data));
		obj.put("data", Base64.getEncoder().encodeToString(data));
		return obj.toString();
//		return new String("{\"begin\":\"1\",\"checksum\":\"1\",\"data\":\"1\"}");
	}
	public static byte[] deflatezip(byte[] bytes) throws IOException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream(bytes.length);
        DeflaterOutputStream zipStream = new DeflaterOutputStream(byteStream,new Deflater( 1, true ), 512);
        zipStream.write(bytes);
        zipStream.close();
        byteStream.close();
        byte[] compressData = byteStream.toByteArray();
        return compressData;
    }
    public static byte[] undeflatezip(byte[] bytes) {
        // tao byteStream va giai nen du lieu, copy vao byteStream
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        try {
            IOUtils.copy(new InflaterInputStream(new ByteArrayInputStream(bytes),new Inflater(true )), byteStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] decompressData = byteStream.toByteArray();
        return decompressData;
    }

}
