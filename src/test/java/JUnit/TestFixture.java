package JUnit;

import org.junit.*;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

/**
 * ${DESCRIPTION}
 *
 * @author 李娜
 * @version 0.0.1
 * @since 0.0.1  2019-10-12
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestFixture {

    @Test
    public void testAdd1() {
        int result = new Count().add(3, 5);
        assertEquals(result, 8);
        System.out.println("测试1");
    }

    @Test
    public void aestAdd2() {
        int result = new Count().add(3, 15);
        assertEquals(result, 18);
        System.out.println("测试2");
    }

    @BeforeClass
    public static void beforeClass() {
        System.out.println("-----------beforeClass");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("-----------afterClass");
    }

    @Before
    public void before() {
        System.out.println("================before");
    }

    @After
    public void after() {
        System.out.println("===============after");
    }
}
