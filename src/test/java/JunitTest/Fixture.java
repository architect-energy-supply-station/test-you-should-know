package JunitTest;

//import JunitTwo.Count;
import Junit.Count;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class Fixture {
    @BeforeClass
    public static void BeforeClass() {
        System.out.println("--------BeforeClass");
    }

    @AfterClass
    public static void AfterClass() {
        System.out.println("-----AfterClass");
    }

    @Before
    public void Before() {
        System.out.println("-----Before");
    }

    @After
    public void After() {
        System.out.println("------After");
    }

    @Test
    public void TestAdd1() {
        int add = new Count().add(2, 5);
        assertEquals(add, 7);

    }
}