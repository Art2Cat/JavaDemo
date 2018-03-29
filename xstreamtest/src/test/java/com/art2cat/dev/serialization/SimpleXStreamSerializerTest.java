package com.art2cat.dev.serialization;

import com.art2cat.dev.model.CountryEnum;
import com.art2cat.dev.model.impl.CountryTimeZone;
import com.art2cat.dev.model.impl.TimeZoneEnum;
import com.art2cat.dev.model.intf.ICountryTimeZone;
import com.art2cat.dev.serialization.simple.SimpleConverter;
import com.art2cat.dev.serialization.simple.SimpleXStreamSerializer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * PACKAGE_NAME
 *
 * @author art2c
 * @date 3/29/2018
 */
public class SimpleXStreamSerializerTest {
    
    private SimpleXStreamSerializer simpleXStreamSerializer = new SimpleXStreamSerializer();
    private Path xmlPath = Paths.get("src", "test", "resources", "objects.xml");
    
    
    private ICountryTimeZone initData() {
        
        ICountryTimeZone countryTimeZone = new CountryTimeZone();
        countryTimeZone.setCountryName("US");
        countryTimeZone.setCountry(CountryEnum.US);
        List<TimeZoneEnum> timeZoneEnums = new ArrayList<>();
        timeZoneEnums.add(TimeZoneEnum.UTC_10W);
        timeZoneEnums.add(TimeZoneEnum.UTC_9V);
        timeZoneEnums.add(TimeZoneEnum.UTC_8U);
        timeZoneEnums.add(TimeZoneEnum.UTC_7T);
        timeZoneEnums.add(TimeZoneEnum.UTC_6S);
        timeZoneEnums.add(TimeZoneEnum.UTC_5R);
        countryTimeZone.setTimeZoneEnumList(timeZoneEnums);
        return countryTimeZone;
    }
    
    @Before
    public void prepare() {
        Path resources = Paths.get("src", "test", "resources");
        if (Files.notExists(resources)) {
            try {
                Files.createDirectory(resources);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    @Test
    public void testSimpleXStreamSerializer() {
        
        try {
            ICountryTimeZone origin = initData();
            simpleXStreamSerializer
                .objectToXML(origin, xmlPath.toString());
            ICountryTimeZone result = (ICountryTimeZone) simpleXStreamSerializer
                .xmlToObject(xmlPath.toString());
            result.getTimeZoneEnumList().forEach(timeZoneEnum -> System.out.println(timeZoneEnum.name()));
            Assert.assertEquals(origin.getCountryName(), result.getCountryName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                Files.deleteIfExists(xmlPath);
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
                .objectToXML(origin, xmlPath.toString());
            
            ICountryTimeZone result = (ICountryTimeZone) simpleXStreamSerializer
                .xmlToObject(xmlPath.toString());
            result.getTimeZoneEnumList().forEach(timeZoneEnum -> System.out.println(timeZoneEnum.name()));
            
            Assert.assertEquals(origin.getCountryName(), result.getCountryName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                Files.deleteIfExists(xmlPath);
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
                .objectToXML(origin, xmlPath.toString());
            
            ICountryTimeZone result = (ICountryTimeZone) serializer
                .xmlToObject(xmlPath.toString());
            result.getTimeZoneEnumList().forEach(timeZoneEnum -> System.out.println(timeZoneEnum.getValue()));
            
            Assert.assertEquals(origin.getCountryName(), result.getCountryName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            try {
//                Files.deleteIfExists(xmlPath);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
    }
    
}
