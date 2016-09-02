package com.clouway.taskone;

import com.google.gson.Gson;
;

import java.lang.reflect.Type;

/**
 * @author Petar Nedelchev <peter.krasimirov@gmail.com>
 */
public class JsonCodec implements MessageCodec {

    private Gson gson = new Gson();

    public String marchall(Object object) {
        return gson.toJson(object);
    }

    public <T> T unmarchall(String message, Class<T> clazz)  {
        return gson.fromJson(message, clazz);
    }

    public <T> T unmarchall(String message, Type type) {
        return gson.fromJson(message, type);
    }
}



