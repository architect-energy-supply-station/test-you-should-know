package Junit5Test;

import org.junit.Test;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

//import static junit.framework.TestCase.assertTrue;`
import static org.junit.jupiter.api.Assertions.assertAll;
//import static org.junit.jupiter.api.Assertions.assertEquals;`


public class JUnit5NewTests {
    @BeforeEach
    @DisplayName("每条用例开始时执行")
    void start() {

    }

    @AfterEach
    @DisplayName("每条用例结束时执行")
    void end() {

    }

    @Test
    void MyFirstTest() {
        assertEquals(2, 1 + 1);
    }

@Test
@DisplayName("运行一组断言")
public void assertAllCase() {
    assertAll("groupAssert",
            () -> assertEquals(2, 1 + 1),
            () -> assertTrue(1 > 0)
    );
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