package com.art2cat.dev.serialization.simple;

import com.art2cat.dev.model.impl.TimeZoneEnum;
import com.art2cat.dev.model.intf.ICustomEnum;
import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import java.lang.reflect.Method;

/**
 * com.art2cat.dev.serialization.simple
 *
 * @author art2c
 * @date 3/29/2018
 */
public class SimpleConverter implements Converter {
    
    /**
     * Convert an object to textual data.
     *
     * @param source The object to be marshalled.
     * @param writer A stream to write to.
     * @param context A context that allows nested objects to be processed by XStream.
     */
    @Override
    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
        
        if (source instanceof ICustomEnum) {
            writer.setValue((String) ((ICustomEnum) source).getValue());
        }
    }
    
    /**
     * Convert textual data back into an object.
     *
     * @param reader The stream to read the text from.
     * @return The resulting object.
     */
    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        Class<?> type = context.getRequiredType();
        if (ICustomEnum.class.isAssignableFrom(type)) {
            try {
                Method method = type.getMethod("getKeyByValue", String.class);
                return method.invoke(null, reader.getValue());
            } catch (Exception e) {
                throw new RuntimeException("Error processing custom plugin type", e);
            }
        }
        return null;
    }
    
    /**
     * Determines whether the converter can marshall a particular type.
     *
     * @param type the Class representing the object type to be converted
     */
    @Override
    public boolean canConvert(Class type) {
        return TimeZoneEnum.class.isAssignableFrom(type);
    }
}
