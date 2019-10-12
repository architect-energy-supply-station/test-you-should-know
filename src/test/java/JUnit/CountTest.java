package JUnit;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * ${DESCRIPTION}
 *
 * @author 李娜
 * @version 0.0.1
 * @since 0.0.1  2019-10-12
 */
public class CountTest {
    @Test(timeout = 100)
    public void testAdd() throws Exception {
        Count count = new Count();
        Thread.sleep(101);
        int result = count.add(2, 2);
    }

    @Test(expected =ArithmeticException.class )
    public void testDivision() {
        Count count = new Count();
        count.division(8, 0);
    }

    @Ignore
    @Test
    public void testAdd2() {
        int add = new Count().add(2, 2);
        assertEquals(add,5);
    }


    String a="1234";
    String b = "2345";
    String c = a;
    String d = "1234";

    @Test
    public void testAssertEquals() {
//      assertEquals(a,b);
        assertEquals(a, d);
//      assertEquals(a, c);
//        assertNotEquals(a,b);
//        assertNull(a);
//        assertNotNull(a);
//        assertSame(a, c);
//        assertSame(a,b);
       fail();

    }
}