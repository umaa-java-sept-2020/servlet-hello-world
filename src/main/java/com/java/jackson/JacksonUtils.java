package com.java.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.models.Employee;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class JacksonUtils {

    private static ObjectMapper mapper = new ObjectMapper();
    public static String toJson(Object o) {
        try {
            return mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T toObject(String json, Class<T> t){
        try {
            return mapper.readValue(json, t);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> T toObject(InputStream json, Class<T> t){
        try {
            return mapper.readValue(json, t);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Employee e = new Employee();
        e.setAge(20);
        e.setName("John");
        e.setUuid(UUID.randomUUID().toString());

        System.out.println(e);
        System.out.println(e.hashCode());
        // object to stream of bytes ( serialization)
        String valueStr = toJson(e);
        System.out.println(valueStr);
        // stream of bytes to object ( deserialization )
        e = toObject(valueStr, Employee.class);
        System.out.println(e.hashCode());
        System.out.println(e);

        InputStream is = JacksonUtils.class.getClassLoader().getResourceAsStream("data.json");
        System.out.println(is);

        e=toObject(is,Employee.class);
        System.out.println(e);
        System.out.println(e.hashCode());

    }
}
