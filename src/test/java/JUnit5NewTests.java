import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import static net.sf.ezmorph.test.ArrayAssertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.testng.Assert.assertTrue;

/**
 * @author 任蒙蒙
 * @version 1.0.0
 * @since 2019/10/12 11:25
 */
public class JUnit5NewTests {
    @BeforeEach
    @DisplayName("每条用例开始时执行")
    void start() {
        System.out.println("开始");
    }

    @AfterEach
    @DisplayName("每条用例结束时执行")
    void end() {
        System.out.println("结束");
    }

    @Test
    void myFirstTest() {
        assertEquals(2, 1 + 1);
    }

    @Test
    @DisplayName("描述测试用例")
    void testWithDisplayName() {

    }

    @Test
    @Disabled("这条用例暂时跑不过，忽略!")
    void myFailTest() {
        assertEquals(122, 2);
    }

    @Test
    @DisplayName("运行一组断言")
    public void assertAllCase() {
        assertAll("groupAssert", () -> assertEquals(2, 1 + 1), () -> assertTrue(1 > 0));

    }

    @Test
    @DisplayName("依赖注入1")
    public void testInfo(final TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }

    @Test
    @DisplayName("依赖注入2")
    public void testReporter(final TestReporter testReporter) {
        testReporter.publishEntry("name", "Alex");
    }
}
