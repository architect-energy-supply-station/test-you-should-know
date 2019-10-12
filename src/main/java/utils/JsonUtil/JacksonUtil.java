package utils.JsonUtil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * ${DESCRIPTION}
 *
 * @author 李娜
 * @version 0.0.1
 * @since 0.0.1  2019-10-05
 */
public class JacksonUtil {

    private static final ObjectMapper mapper = new ObjectMapper();

    private JacksonUtil() {

    }

    // object 转json
    public static String objectToJson(Object object) throws JsonProcessingException {
        return mapper.writeValueAsString(object);
    }

    // json 转 object
    public static <T> T jsonToObject(String json, Class<T> clazz) throws IOException {
        return mapper.readValue(json, clazz);
    }
}
