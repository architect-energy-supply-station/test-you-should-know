package RuleTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

public class RuleTestDemo {
    @Rule
    public Timeout timeout = new Timeout(100);

    @Rule
    public MethodNameRule methodNameRule = new MethodNameRule();
    @Test
    public void testMethod1() throws InterruptedException {
        Thread.sleep(99);

    }


    @Test
    public void testMethod2() throws InterruptedException {
        Thread.sleep(99);

    }
}
