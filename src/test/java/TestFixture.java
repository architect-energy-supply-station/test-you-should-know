import junitTest.Count;
import org.junit.*;

import static net.sf.ezmorph.test.ArrayAssertions.assertEquals;

/**
 * @author 任蒙蒙 todo
 * @version 1.0.0
 * @since 2019/10/12 9:57
 */
public class TestFixture {
    //在当前测试类开始时运行。
    @BeforeClass
    public static void beforeClass() {
        System.out.println("----beforeClass");
    }

    //在当前测试类结束时运行。
    @AfterClass
    public static void afterClass() {
        System.out.println("----afterClass");
    }

    //每个测试方法运行之前运行
    @Before
    public void before() {
        System.out.println("===before");
    }

    //每个测试方法运行之后运行
    @After
    public void after() {
        System.out.println("===after");
    }

    @Test
    public void testAdd1() {
        int result = new Count().add(5, 3);
        assertEquals(8, result);
        System.out.println("test Run testadd1");
    }

    @Test
    public void testAdd2() {
        int result = new Count().add(15, 13);
        assertEquals(28, result);
        System.out.println("test Run testadd2");
    }

}
