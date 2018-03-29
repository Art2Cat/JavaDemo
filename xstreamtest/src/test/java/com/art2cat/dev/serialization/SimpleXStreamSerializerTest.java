package com.art2cat.dev.serialization;

import com.art2cat.dev.model.impl.TimeZoneEnum;
import com.art2cat.dev.model.impl.CountryTimeZone;
import com.art2cat.dev.model.intf.ICountryTimeZone;
import com.art2cat.dev.serialization.simple.SimpleConverter;
import com.art2cat.dev.serialization.simple.SimpleXStreamSerializer;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 * PACKAGE_NAME
 *
 * @author art2c
 * @date 3/29/2018
 */
public class SimpleXStreamSerializerTest {
    
    private SimpleXStreamSerializer simpleXStreamSerializer = new SimpleXStreamSerializer();
    private static File path = Paths.get("src", "test", "resources", "objects.xml").toFile();
    
    
    private ICountryTimeZone initData() {
        
        ICountryTimeZone countryTimeZone = new CountryTimeZone();
        countryTimeZone.setCountryName("US");
        List<TimeZoneEnum> timeZoneEnums = new ArrayList<>();
        timeZoneEnums.add(TimeZoneEnum.UTC_5E);
        timeZoneEnums.add(TimeZoneEnum.UTC_0Z);
        timeZoneEnums.add(TimeZoneEnum.UTC_2O);
        timeZoneEnums.add(TimeZoneEnum.UTC_3CH);
        countryTimeZone.setTimeZoneEnumList(timeZoneEnums);
        return countryTimeZone;
    }
    
    @Test
    public void testSimpleXStreamSerializer() {
        
        try {
            ICountryTimeZone origin = initData();
            simpleXStreamSerializer
                .objectToXML(origin, path.getAbsolutePath());
            ICountryTimeZone result = (ICountryTimeZone) simpleXStreamSerializer
                .xmlToObject(path.getAbsolutePath());
            result.getTimeZoneEnumList().forEach(timeZoneEnum -> System.out.println(timeZoneEnum.name()));
            Assert.assertEquals(origin.getCountryName(), result.getCountryName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                Files.delete(Paths.get(path.getAbsolutePath()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    
    @Test
    public void testSimpleXStreamSerializerWithAlias() {
        
        try {
            ICountryTimeZone origin = initData();
            simpleXStreamSerializer.setClassAlias("timeZone", TimeZoneEnum.class);
            simpleXStreamSerializer.setFieldAlias("timeZoneList", List.class, "timeZoneEnumList");
            simpleXStreamSerializer.setAttributeAlias(CountryTimeZone.class, "countryName", "name");
            simpleXStreamSerializer
                .objectToXML(origin, path.getAbsolutePath());
            
            ICountryTimeZone result = (ICountryTimeZone) simpleXStreamSerializer
                .xmlToObject(path.getAbsolutePath());
            result.getTimeZoneEnumList().forEach(timeZoneEnum -> System.out.println(timeZoneEnum.name()));
            
            Assert.assertEquals(origin.getCountryName(), result.getCountryName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                Files.delete(Paths.get(path.getAbsolutePath()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    @Test
    public void testSimpleXStreamSerializerWithAliasAndConverter() {
        SimpleXStreamSerializer serializer = new SimpleXStreamSerializer(false, new SimpleConverter());
        try {
            ICountryTimeZone origin = initData();
            serializer.setClassAlias("timeZone", TimeZoneEnum.class);
            serializer.setFieldAlias("timeZoneList", List.class, "timeZoneEnumList");
            serializer.setAttributeAlias(CountryTimeZone.class, "countryName", "name");
            serializer
                .objectToXML(origin, path.getAbsolutePath());
            
            ICountryTimeZone result = (ICountryTimeZone) serializer
                .xmlToObject(path.getAbsolutePath());
            result.getTimeZoneEnumList().forEach(timeZoneEnum -> System.out.println(timeZoneEnum.getValue()));
            
            Assert.assertEquals(origin.getCountryName(), result.getCountryName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                Files.delete(Paths.get(path.getAbsolutePath()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
