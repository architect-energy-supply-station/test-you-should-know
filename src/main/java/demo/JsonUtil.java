package demo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;
import net.sf.json.xml.XMLSerializer;

import java.util.Map;

/**
 * @author 任蒙蒙
 * @version 1.0.0
 * @since 2019/10/4 20:05
 */
public class JsonUtil {
    //将数组转换成String类型的Json数据格式
    public static String array2json(Object[] objects) {
        JSONArray jsonArray = JSONArray.fromObject(objects);
        return jsonArray.toString();
    }

    //    list转我String类型的Json
    public static String list2json(Object[] objects) {
        JSONArray jsonArray = JSONArray.fromObject(objects);
        return jsonArray.toString();
    }

    //    object集合转换成String的Json
    public static String object2json(Object[] object) {
        JSONObject jsonObject = JSONObject.fromObject(object);
        return jsonObject.toString();
    }

    //    map-json
    public static String map2json(Map map) {
        JSONObject jsonObject = JSONObject.fromObject(map);
        return jsonObject.toString();
    }

    //    xml-Json
    public static String xml2Json(String xml) {
        JSONArray jsonArray = (JSONArray) new XMLSerializer().read(xml);
        return jsonArray.toString();
    }

    public static JsonConfig configJson(String[] excludes) {
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.setExcludes(excludes);
        jsonConfig.setIgnoreDefaultExcludes(true);
        jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
        return jsonConfig;
    }

}

