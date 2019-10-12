package Junit5Test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import java.security.PublicKey;

public class RuleTestDemo {

    @Rule
    public Timeout timeout = new Timeout(1000);

    @Rule
    public MethodNameRule methodNameRule = new MethodNameRule();

    @Test
    public void testMethod1() throws  Exception {
        Thread.sleep(1001);
    }
    @Test
    public void testMethod2() throws Exception {
        Thread.sleep(999);
    }
}