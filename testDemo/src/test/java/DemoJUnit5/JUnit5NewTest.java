package DemoJUnit5;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class JUnit5NewTest {
    @BeforeEach
    @DisplayName("每条用例开始时zhixing")
    void start() {
        System.out.println("每条用例开始时zhixing");
    }

    @AfterEach
    @DisplayName("每条用例结束时zhixing")
    void end() {
        System.out.println("每条用例结束时zhixing");
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
     void assertAllCase() {
        System.out.println("运行断言");
        assertAll("groupAssert",
                () -> assertEquals(2, 1 + 1),
                () -> assertTrue(1 > 0));

    }

    @Test
    @DisplayName("依赖注入1")
     void testInfo(final TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }

    @Test
    @DisplayName("依赖注入2")
     void testReporter(final TestReporter testReporter) {
        System.out.println(testReporter.getClass());
        testReporter.publishEntry("name","Alex");
    }
}
