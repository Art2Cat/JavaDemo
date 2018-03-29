package com.art2cat.dev.serialization.impl;

import com.art2cat.dev.serialization.intf.IRorXStreamSerializer;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.Converter;
import lombok.NoArgsConstructor;
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
    
    public RorXStreamSerializer() {
    }
    
    public RorXStreamSerializer(Converter converter) {
        this.converter = converter;
        configure();
    }
    
    private void configure() {
    
    
    }
    
    @Override
    public Object serialize(Object obj, Object writer) throws Exception {
        return null;
    }
}
