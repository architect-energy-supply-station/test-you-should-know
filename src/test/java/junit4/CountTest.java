package junit4;

import junitTest.Count;
import org.junit.Ignore;
import org.junit.Test;

import static net.sf.ezmorph.test.ArrayAssertions.assertEquals;

/**
 * @author 任蒙蒙
 * @version 1.0.0
 * @since 2019/10/12 9:37
 */
public class CountTest {
    @Test
    public void testAdd() {
        Count count = new Count();
        int result = count.add(2, 2);
        assertEquals(result, 4);
    }

    //验证超时
    @Test(timeout = 100)
    public void testAddTime() throws InterruptedException {
//        todo ??
        Thread.sleep(101);
        new Count().add(1, 1);

    }

    //验证抛出异常 todo
    @Test(expected = ArithmeticException.class)
    public void testDivision() {
        new Count().division(8, 0);
    }

    // 跳过该条用例
    @Ignore
    @Test
    public void testAdd2() {
        Count count = new Count();
        int result = count.add(2, 2);
        assertEquals(result, 5);
    }
}
