package vn.vcc.adopt.server.sparkserver.core;

import org.apache.commons.lang3.SerializationUtils;
import vn.vcc.adopt.tools.Tool;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by chiennv on 10/08/2017.
 */
public class SaveObject {
    /**
     * chia object thanh cac chunk roi put vao mapper
     * @param object
     * @param classname
     */
    public void saveObject(Object object, Class classname) {

        SparkServer.getBegin().clear();
        SparkServer.getMapper().clear();

        try {
            byte[] bytes = SerializationUtils.serialize((Serializable) object);
            SparkServer.setTotal(bytes.length);
            int chunkSize = 10 * 1024 * 1024;
            SparkServer.setClassName(classname.toString());
            for (int i = 0, stt = 0; i < bytes.length; i += chunkSize) {
                byte[] chunk = Arrays.copyOfRange(bytes, i, Math.min(bytes.length, i + chunkSize));
                chunk = Tool.gzip(chunk);
                SparkServer.getMapper().put(stt, chunk);
                stt++;
                SparkServer.getBegin().add(i);
            }
            System.out.println(SparkServer.getMapper().size());
            SparkServer.setTimestamp(System.nanoTime());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
