package com.art2cat.dev.json;

import com.art2cat.dev.corejava.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import javax.sql.rowset.spi.XmlReader;

/**
 * @author huang.yiming
 */
public class SerializeJsonBasicType {
    
    public String serializePerson(Person o, SerializationFeature mode) throws IOException {
        var mapper = new ObjectMapper();
        mapper.configure(mode, true);
        return mapper.writeValueAsString(o);
        
    }
    
    public Person deserializePerson(String s, SerializationFeature mode) throws IOException {
        var mapper = new ObjectMapper();
        mapper.configure(mode, true);
        return mapper.readValue(s, Person.class);
    }
    
    public String xmlToJson(byte[] xml, SerializationFeature mode) throws IOException {
        var xmlMapper = new XmlMapper();
        xmlMapper.configure(mode, true);
        var person = xmlMapper.readValue(xml, Person.class);
        return serializePerson(person, mode);
    }
    
    public String jsonToXml(byte[] json, SerializationFeature mode) throws IOException {
        var person = deserializePerson(new String(json), mode);
        
        var xmlMapper = new XmlMapper();
        xmlMapper.configure(mode, true);
        return xmlMapper.writeValueAsString(person);
    }
}
