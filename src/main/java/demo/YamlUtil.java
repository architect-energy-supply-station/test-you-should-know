package demo;

import org.springframework.beans.factory.config.YamlMapFactoryBean;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.Assert;

import java.util.Map;
import java.util.Properties;

/**
 * @author 任蒙蒙
 * @version 1.0.0
 * @since 2019/10/3 17:10
 */
public class YamlUtil {
    public static Map<String, Object> yaml2Map(String yamlSource) {

        try {
            YamlMapFactoryBean yaml = new YamlMapFactoryBean();
            yaml.setResources(new ClassPathResource(yamlSource));

            return yaml.getObject();
        } catch (Exception e) {
            return null;
        }
    }

    public static Properties yamlProperties(String yamlSource) {
        try {
            YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
            yamlPropertiesFactoryBean.setResources(new ClassPathResource(yamlSource));
            return yamlPropertiesFactoryBean.getObject();
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        Map<String, Object> map = YamlUtil.yaml2Map("mm.yml");
        Assert.notNull(map);
        map.forEach((k, v) -> {
            System.out.println("k=" + k + "v={}" + v);
        });
    }
}
