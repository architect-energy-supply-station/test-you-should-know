package DemoJUnit5;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class JUnit5NewTest {
    @BeforeEach
    @DisplayName("每条用例开始时zhixing")
    void start() {

    }

    @AfterEach
    @DisplayName("每条用例结束时zhixing")
    void end() {

    }

    @Test
    void myFirstTest() {
        assertEquals(1 + 1, 2);
    }

    @Test
    @DisplayName("描述测试用力")
    void testWithDisplayName() {

    }

    @Test
    @Disabled("这条用例暂时不跑,跳过")
    void myFailTest() {
        assertEquals(1, 2);
    }

    @Test
    @DisplayName("运行一组断言")
    public void assertAllCase() {
        assertAll("groupAssert",
                () -> assertEquals(2, 1 + 1),
                () -> assertTrue(1 > 0));

    }

    @Test
    @DisplayName("依赖注入1")
    public void testInfo(final TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }

    @Test
    @DisplayName("依赖注入2")
    public void testReporter(final TestReporter testReporter) {
        testReporter.publishEntry("name","Alex");
    }
}
