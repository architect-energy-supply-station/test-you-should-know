package utils.propertyUtils;

/**
 * ${DESCRIPTION}
 *
 * @author 李娜
 * @version 0.0.1
 * @since 0.0.1  2019-10-03
 */
public class PropertyTest {
    public static void main(String[] args) {
        String value=PropertyUtil.getProperty("jdbc.properties", "name");
        System.out.println(value);
    }
}
