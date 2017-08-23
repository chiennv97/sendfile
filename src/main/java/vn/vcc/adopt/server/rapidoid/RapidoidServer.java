package vn.vcc.adopt.server.rapidoid;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.zip.GZIPOutputStream;

import org.rapidoid.http.Req;
import org.rapidoid.http.ReqHandler;
import org.rapidoid.http.Resp;

import vn.vcc.adopt.server.model.Data;
import vn.vcc.adopt.tools.Tool;

public class RapidoidServer implements ReqHandler {

	private Data data;

	public RapidoidServer(Data data){
		this.data = data;
	}

	public Object execute(Req req) throws Exception {
		// TODO Auto-generated method stub
		Resp resp = req.response();
		if (req.verb().equals("HEAD")) {
			resp.header("Length", data.getData().length + "");
			resp.header("ETag", data.getTimestamp() + "");
			return resp;
		} else{
			String range = req.header("Range");
			OutputStream output = resp.out();
			InputStream input = new ByteArrayInputStream(data.getData());
			output = new GZIPOutputStream(output, 10240);
			if (range != null) {
				String[] arr1 = range.split("=");
				String[] arr2 = arr1[1].split("-");
				long start = Long.parseLong(arr2[0]);
				long end = Long.parseLong(arr2[1]);
				String checksum = Tool.calChecksum(Arrays.copyOfRange(data.getData(), Integer.parseInt(start+""), Integer.parseInt((end+1)+"")));
				resp.header("Checksum", checksum);
				Tool.copy(input, output, start, end - start + 1);
			} else {
				String checksum = Tool.calChecksum(Arrays.copyOfRange(data.getData(), 0, data.getData().length));
				resp.header("Checksum", checksum);
				Tool.copy(input, output, 0, data.getData().length);
			}
			output.close();
			return resp;
		}
	}

}
