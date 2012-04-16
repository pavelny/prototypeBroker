package com.copyright.rup.works.broker.api;

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
     * The method converts JSON to POJOs.
     *
     * @param <T>
     *            The type, in which JSON spring will be converted.
     * @param json
     *            the JSON representation of POJOs.
     * @return the POJO list.
     */
    <T> List<T> toEntities(String json);

    /**
     * The method converts JSON to POJO.
     *
     * @param <T>
     *            The type, in which JSON spring will be converted.
     * @param json The JSON representation of object.
     * @param clazz The class in which we convert JSON string.
     * @return The POJO.
     */
    <T> T toEntity(String json, Class<T> clazz);

    /**
     * The method converts POJO to JSON.
     *
     * @param obj
     *            The POJO object.
     * @return The string representation of JSON.
     */
    String toJson(Object obj);
}
