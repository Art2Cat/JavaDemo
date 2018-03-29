package com.art2cat.dev.serialization.simple;

import com.art2cat.dev.serialization.impl.RorXStreamSerializer;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.reflection.PureJavaReflectionProvider;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * com.art2cat.dev.serialization.impl
 *
 * @author art2c
 * @date 3/29/2018
 */
public class SimpleXStreamSerializer {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleXStreamSerializer.class);
    
    private XStream xStream;
    
    
    public SimpleXStreamSerializer() {
        xStream = new XStream(new DomDriver());
    }
    
    public SimpleXStreamSerializer(boolean isPureJava, Converter converter) {
        if (isPureJava) {
            xStream = new XStream(new PureJavaReflectionProvider(), new DomDriver());
        } else {
            xStream = new XStream(new DomDriver());
        }
        xStream.registerConverter(converter);
    }
    
    public void setClassAlias(String alias, Class<?> clazz) {
        xStream.alias(alias, clazz);
    }
    
    public void setFieldAlias(String alias, Class<?> clazz, String fieldName) {
        xStream.aliasField(alias, clazz, fieldName);
    }
    
    public void setAttributeAlias(Class<?> clazz, String attributeName, String alias) {
        xStream.aliasAttribute(clazz, attributeName, alias);
        xStream.useAttributeFor(clazz, attributeName);
    }
    
    private void removeParentNode(Class<?> clazz, String fieldName) {
        xStream.addImplicitCollection(clazz, fieldName);
    }
    
    public void objectToXML(Object object, String xmlPath) throws Exception {
        try (FileOutputStream outputStream = new FileOutputStream(xmlPath)) {
            xStream.toXML(object, outputStream);
        }
    }
    
    public Object xmlToObject(String xmlPath) throws Exception {
        try (FileInputStream inputStream = new FileInputStream(xmlPath)) {
            return xStream.fromXML(inputStream);
        }
    }
}
