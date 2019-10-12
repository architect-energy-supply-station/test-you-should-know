package utils.propertyUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * JDK 自带  java.util包
 *
 * @author 李娜
 * @version 0.0.1
 * @since 0.0.1  2019-10-03
 */
public class PropertyUtil {
    private static Properties prop;

    private static void loadProp(String configName) {
        // 获取当前类的class对象的类加载器去加载资源并转化成字节流
        InputStream in = PropertyUtil.class.getClassLoader().getResourceAsStream(configName);
        prop=new Properties();

        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("文件读取失败");
        }

        if (in!=null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getProperty(String name,String key) {
        if (prop==null) {
            loadProp(name);
        }
        return prop.getProperty(key);
    }

    public static String getProperty(String name, String key, String value) {
        if (prop==null) {
            loadProp(name);
        }
        return prop.getProperty(key, value);
    }
}
