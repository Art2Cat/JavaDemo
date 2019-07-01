package com.art2cat.dev;

import com.art2cat.dev.corejava.Person;
import com.art2cat.dev.json.SerializeJsonBasicType;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SerializeJsonBasicTypeTest {


    private Person person;
    private String jsonFromFile;
    private byte[] xmlFromFile;

    @BeforeEach
    public void before() throws IOException {
        person = new Person("test", 12, 133, "female", LocalDateTime.of(2019,7,1,0,0));
        Path jsonFile = Paths.get("src", "test", "resources", "person.json");
        if (Files.exists(jsonFile)) {
            jsonFromFile = Files.readString(jsonFile);
        }
        Path xmlFile = Paths.get("src", "test", "resources", "person.xml");
        if (Files.exists(xmlFile)) {
            xmlFromFile = Files.readAllBytes(xmlFile);
        }
    }

    @Test
    public void serializePersonTest() {
        SerializeJsonBasicType serializeJsonBasicType = new SerializeJsonBasicType();
        try {
            var json = serializeJsonBasicType
                    .serializePerson(person, SerializationFeature.INDENT_OUTPUT);
            System.out.println(json);
            Assertions.assertEquals(jsonFromFile, json);
        } catch (IOException e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void deserializePersonTest() {
        SerializeJsonBasicType serializeJsonBasicType = new SerializeJsonBasicType();
        try {
            var p = serializeJsonBasicType
                    .deserializePerson(jsonFromFile, SerializationFeature.INDENT_OUTPUT);

            System.out.println(p);
            Assertions.assertEquals(person, p);
        } catch (IOException e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void xmlToJsonTest() {
        SerializeJsonBasicType serializeJsonBasicType = new SerializeJsonBasicType();
        try {
            var json = serializeJsonBasicType
                    .xmlToJson(xmlFromFile, SerializationFeature.INDENT_OUTPUT);

            if (Objects.isNull(json)) {
                Assertions.fail("json is null");
            }
            System.out.println(json);
            Assertions.assertEquals(jsonFromFile, json);
        } catch (IOException e) {
            Assertions.fail(e.getMessage());
        }
    }

    @Test
    public void jsonToXmlTest() {
        SerializeJsonBasicType serializeJsonBasicType = new SerializeJsonBasicType();
        try {
            var xml = serializeJsonBasicType
                    .jsonToXml(jsonFromFile.getBytes(), SerializationFeature.INDENT_OUTPUT);

            if (Objects.isNull(xml)) {
                Assertions.fail("xml is null");
            }
            System.out.println(xml);

            Assertions.assertEquals(new String(xmlFromFile), xml.trim());
        } catch (IOException e) {
            Assertions.fail(e.getMessage());
        }
    }
}
