package com.clouway.taskone;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.lang.reflect.Type;

/**
 * @author Petar Nedelchev <peter.krasimirov@gmail.com>
 */
public class XmlCodec implements MessageCodec {

    private final XStream xstream = new XStream(new StaxDriver());

    public String marchall (Object object) {
        xstream.processAnnotations(object.getClass());
        return xstream.toXML(object);
    }

    public <T> T unmarchall (String xml, Class<T> clazz) {
        xstream.processAnnotations(clazz);
        return (T) xstream.fromXML(xml);
    }

    @Override
    public <T> T unmarchall(String message, Type type) {
        return (T) xstream.fromXML(message);
    }

    public Object unmarchall (String xml) {
        return  xstream.fromXML(xml);
    }
}
