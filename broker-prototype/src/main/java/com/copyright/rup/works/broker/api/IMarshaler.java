package com.copyright.rup.works.broker.api;

import java.io.IOException;
import java.util.List;

/**
 * This interface is used for converting POJO to JSON format.
 * <p/>
 * Copyright (C) 2012 copyright.com
 * <p/>
 * Date: 04/13/12.
 *
 * @author Andrei_Khadziukou
 */
public interface IMarshaler {

    /**
     * The method converts JSON to POJOs
     *
     * @param json
     *            the JSON representation of POJOs.
     * @return the POJO list.
     */
    <T> List<T> toEntities(String json);

    /**
     * The method converts JSON to POJO
     *
     * @param json
     * @param clazz
     * @return
     */
    <T> T toEntity(String json, Class<T> clazz);

    /**
     * The method converts POJO to JSON
     *
     * @param obj
     *            The POJO object.
     * @return The string representation of JSON.
     * @throws IOException
     */
    String toJson(Object obj);
}
