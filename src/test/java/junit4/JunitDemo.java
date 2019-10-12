package junit4;

import org.junit.Test;

import static net.sf.ezmorph.test.ArrayAssertions.assertEquals;

/**
 * @author 任蒙蒙
 * @version 1.0.0
 * @since 2019/10/12 9:33
 */
public class JunitDemo {
    @Test
    public void myFirstTest() {
//        assertEquals() 方法用于断言两个值是否相关。
        assertEquals(2 + 2, 4);
    }

}
