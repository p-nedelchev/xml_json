package com.clouway.taskone;

import java.lang.reflect.Type;

/**
 * @author Petar Nedelchev <peter.krasimirov@gmail.com>
 */
public interface MessageCodec {
    String marchall (Object  o);
    <T> T unmarchall(String message, Class<T> clazz);
    <T> T unmarchall(String message, Type type);
}
