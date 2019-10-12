package utils.JsonUtil;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.poi.ss.formula.functions.T;

import java.util.List;
import java.util.Map;

/**
 * gson
 *
 * @author 李娜
 * @version 0.0.1
 * @since 0.0.1  2019-10-05
 */
public class gsonUtil {
    private static Gson gson = null;

    private gsonUtil() {
    }

    static {
        if (gson==null) {
            gson = new Gson();
        }
    }

    // 对象转换成json
    public static String gsonString(Object object) {
        String gsonString = null;
        if (gson!=null) {
            gsonString = gson.toJson(object);
        }
        return gsonString;
    }

    // json 转对象
    public static T gsonToObject(String gsonString,Class<T> claszz) {
        T t = null;
        if (gson!=null) {
            t = gson.fromJson(gsonString, claszz);
        }
        return t;
    }

    // json 转list集合
    public static List<T> gsonToList(String gsonString, Class<T> clazz) {
        List<T> list = null;

        if (gson!=null) {
           list= gson.fromJson(gsonString, new TypeToken<List<T>>() {
            }.getType());
        }
        return list;

    }

    // json 转list中的ma
    public static  <T> List<Map<String, T>> gosnToListMap(String gsonString) {
        List<Map<String, T>> list = null;
        if (gson!=null) {
            list = gson.fromJson(gsonString, new TypeToken<List<Map<String, T>>>(){}.getType());
        }
        return list;
    }

    // json 转 map
    public static <T> Map<String, T> gsonToMap(String gsonString) {
        Map<String, T> map = null;
        if (gson!=null) {
            map=gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {
            }.getType());
        }
        return map;
    }
}
