package utils.ymlUtils;

import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;

import java.util.Map;
import java.util.Properties;

/**
 * springframework 框架
 *
 * @author 李娜
 * @version 0.0.1
 * @since 0.0.1  2019-10-03
 */
public class YmlUtils {
    public static Map<String,Object> yml2Map(String ymlSource) {
        YamlMapFactoryBean yaml = new YamlMapFactoryBean();
        yaml.setResources(new ClassPathResource(ymlSource));
        return yaml.getObject();
    }

    public static Properties yaml2Properties(String ymlSource) {
        YamlPropertiesFactoryBean yaml = new YamlPropertiesFactoryBean();
        yaml.setResources(new ClassPathResource(ymlSource));
        return yaml.getObject();
    }
}
