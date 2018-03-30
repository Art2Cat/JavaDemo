package com.art2cat.dev.serialization.impl;

import com.art2cat.dev.serialization.intf.IRorXStreamSerializer;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.reflection.PureJavaReflectionProvider;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.QNameMap;
import com.thoughtworks.xstream.io.xml.StaxReader;
import com.thoughtworks.xstream.io.xml.StaxWriter;
import java.io.InputStream;
import java.io.OutputStream;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * com.art2cat.dev.serialization.impl
 *
 * @author art2c
 * @date 3/29/2018
 */
public class RorXStreamSerializer implements IRorXStreamSerializer {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(RorXStreamSerializer.class);
    private Converter converter;
    private XStream xStream;
    private boolean isPureJava;
    
    public RorXStreamSerializer() throws Exception {
        configure();
    }
    
    public RorXStreamSerializer(Converter converter) throws Exception {
        this.converter = converter;
        configure();
    }
    
    public RorXStreamSerializer(boolean isPureJava, Converter converter) throws Exception {
        this.converter = converter;
        this.isPureJava = isPureJava;
        configure();
    }
    
    private void configure() throws Exception {
        try {
            if (isPureJava) {
                xStream = new XStream(new PureJavaReflectionProvider(), new DomDriver());
            } else {
                xStream = new XStream(new DomDriver());
            }
            
            // use custom converter if provided
            if (converter != null) {
                xStream.registerConverter(converter);
            } else {
                xStream.registerConverter(new EnumConverter());
            }
            
            xStream.setMode(XStream.ID_REFERENCES);
        } catch (Throwable e) {
            LOGGER.error("Error configure XStream", e);
            throw new Exception(e);
        }
        
    }
    
    /**
     * make the object serialize, and return the object string.
     */
    @Override
    public Object serialize(Object obj) throws Exception {
        try {
            return xStream.toXML(obj);
        } catch (Exception e) {
            throw new Exception("XStream Serializer: Could not serialize object: " + obj, e);
        }
    }
    
    /**
     * Serialize the Object obj to a specific Writer writer.
     */
    @Override
    public Object serialize(Object obj, Object writer) throws Exception {
        try {
            if (writer instanceof OutputStream) {
                xStream.toXML(obj, (OutputStream) writer);
            } else if (writer instanceof XMLStreamWriter) {
                xStream.marshal(obj, new StaxWriter(new QNameMap(), (XMLStreamWriter) writer));
            } else {
                LOGGER.info(writer.getClass() + " is an none-supported writer.");
            }
        } catch (Exception e) {
            throw new Exception("XStream Serializer: Could not serialize object: " + obj, e);
        }
        return writer;
    }
    
    /**
     * make the object deserialize and return it.
     */
    @Override
    public Object deserialize(Object obj) throws Exception {
        try {
            if (obj instanceof InputStream) {
                return xStream.fromXML((InputStream) obj);
            } else if (obj instanceof String) {
                return xStream.fromXML((String) obj);
            } else if (obj instanceof XMLStreamReader) {
                return xStream.unmarshal(new StaxReader(new QNameMap(), (XMLStreamReader) obj));
            } else {
                throw new Exception("XStream serializer only supports String or InputStream inputs: " + obj);
            }
        } catch (Exception e) {
            throw new Exception("An exception occured during XStream deserialization.", e);
        }
    }
}
