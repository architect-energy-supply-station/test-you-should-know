import org.junit.Test;

import static org.testng.Assert.assertTrue;

/**
 * @author 任蒙蒙
 * @version 1.0.0
 * @since 2019/10/12 10:19
 */
public class AssertTest {
    /**
     * 判断一个数是否为素数
     */
    public static Boolean Prime(int n) {
        for (int i = 0; i < Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    public void testPrime() {
        int n = 7;
        assertTrue(AssertTest.Prime(n));
    }
}
