import org.junit.jupiter.api.Test;

import static net.sf.ezmorph.test.ArrayAssertions.assertEquals;

/**
 * @author 任蒙蒙
 * @version 1.0.0
 * @since 2019/10/12 11:23
 */
class FistJUnit5Tests {
    @Test
    void myFirstTest() {
        assertEquals(2, 1 + 1);
    }
}
