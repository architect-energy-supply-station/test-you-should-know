package JunitTest;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class AssertTest {
    public static Boolean Prime(int n) {
        for (int i = 2; i <Math.sqrt(n) ; i++) {
            if (n%i==0) {
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