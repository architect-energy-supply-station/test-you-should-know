package junit4;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static net.sf.ezmorph.test.ArrayAssertions.assertEquals;

/**
 * @author 任蒙蒙
 * @version 1.0.0
 * @since 2019/10/12 10:10
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRunSequence {

    @Test
    public void TestCase1() {
        assertEquals(2+2,4);
    }
    @Test
    public void TestCase2() {
        assertEquals(2+2,4);
    }
    @Test
    public void TestAa() {
        assertEquals("hello","hi");
    }


}
