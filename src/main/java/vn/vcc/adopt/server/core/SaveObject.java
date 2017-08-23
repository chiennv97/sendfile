package vn.vcc.adopt.server.core;

import java.io.Serializable;

import org.apache.commons.lang3.SerializationUtils;

import vn.vcc.adopt.server.model.Data;

/**
 * Created by chiennv on 10/08/2017.
 */
public class SaveObject {
    /**
     * chia object thanh cac chunk roi put vao mapper
     *
     * @param object
     *
     */
    public static void saveObject(Data data,Object object) {
    	data.setData(SerializationUtils.serialize((Serializable) object));
    	data.setTimestamp(System.nanoTime());
    	System.out.println(data.getData().length);
    }

}
