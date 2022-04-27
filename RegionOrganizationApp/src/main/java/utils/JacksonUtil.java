package utils;

import com.fasterxml.jackson.databind.ObjectMapper;


public class JacksonUtil {
    private final static ObjectMapper mapper = createMapper();

    public static ObjectMapper getMapper() {
        return mapper;
    }

    public static ObjectMapper createMapper() {
        return new ObjectMapper();
    }
}
