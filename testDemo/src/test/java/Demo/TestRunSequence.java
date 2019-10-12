package Demo;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRunSequence {
    @Test
    public void testCase1() {
        assertEquals(2 + 2, 4);
        System.out.println("成功");
    }

    @Test
    public void testCase2() {
        assertEquals(2 + 2, 4);
        System.out.println("成功");
    }

    @Test
    public void TestAa() {
        assertEquals("hello","hello");
    }
}
