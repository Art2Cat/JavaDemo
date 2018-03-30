package com.art2cat.dev.serialization.intf;

/**
 * com.art2cat.dev.serialization.intf
 *
 * @author art2c
 * @date 3/29/2018
 */
public interface IRorXStreamSerializer {
    
    Object serialize(Object obj) throws Exception;
    
    Object serialize(Object obj, Object writer) throws Exception;
    
    Object deserialize(Object obj) throws Exception;
}
