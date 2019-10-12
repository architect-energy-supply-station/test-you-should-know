package utils.ymlUtils;

import org.springframework.util.Assert;

import java.util.Map;
import java.util.Properties;

/**
 * ${DESCRIPTION}
 *
 * @author 李娜
 * @version 0.0.1
 * @since 0.0.1  2019-10-03
 */
public class YmlTest {
    public static void main(String[] args) {
        Map<String, Object> map = YmlUtils.yml2Map("jdbc.yml");
        if (map!=null) {
            for (Map.Entry<String,Object> entrySet : map.entrySet()) {
                System.out.println(entrySet.getKey() + "  " + entrySet.getValue());
            }
        }

        Properties properties = YmlUtils.yaml2Properties("jdbc.properties");
        System.out.println(properties.getProperty("name"));
    }
}
