package br.com.jota.refl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ObjectToJson {
    public String transforme(Object object) {
        String result = null;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        Map<String, Object> mapper = new HashMap<>();
        Class<?> objectToBeTransformed = object.getClass();

        Arrays.stream(objectToBeTransformed.getDeclaredFields()).toList().forEach(
                field -> {
                    field.setAccessible(true);
                    String key = field.getName();
                    Object value = null;
                    try {
                        value = field.get(object);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                    mapper.put(key, value);
                }
        );

        try {
            result = objectMapper.writeValueAsString(mapper);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return result;
    }
}
