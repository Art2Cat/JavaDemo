package com.art2cat.dev.serialization.impl;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/**
 * com.art2cat.dev.serialization.impl
 *
 * @author rorschach
 * @date 3/29/18
 */
public class EnumConverter implements Converter {
    
    @Override
    public void marshal(Object o, HierarchicalStreamWriter writer,
        MarshallingContext context) {
        if (o instanceof Enum) {
            writer.setValue(((Enum) o).name());
        }
    }
    
    @Override
    public Object unmarshal(HierarchicalStreamReader reader,
        UnmarshallingContext context) {
        Class<?> clazz = context.getRequiredType();
        
        return Enum.class.isAssignableFrom(clazz) ? Enum.valueOf(Enum.class, reader.getValue())
            : null;
    }
    
    @Override
    public boolean canConvert(Class aClass) {
        return Enum.class.isAssignableFrom(aClass);
    }
}
