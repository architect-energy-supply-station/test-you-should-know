package junit5;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * @author 任蒙蒙
 * @version 1.0.0
 * @since 2019/10/12 11:37
 */
public class RuleTestDemo {
    @Rule
    public Timeout timeout = new Timeout(1000);

    @Test
    public void testMethod1() throws InterruptedException {
        Thread.sleep(1001);
    }

    @Test
    public void testMethod2() throws InterruptedException {
        Thread.sleep(999);
    }

    @Rule
    public MethodNameRule methodNameRule = new MethodNameRule();
}
