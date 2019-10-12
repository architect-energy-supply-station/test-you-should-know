package DemoJUnit4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JunitDemo {
    @Test
    public void myFirstTest() {
        //两值是否相等
        assertEquals(2 + 2, 4);
    }
}
