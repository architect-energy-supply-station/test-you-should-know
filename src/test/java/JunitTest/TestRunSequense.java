package JunitTest;

//import JunitTwo.Count;
import Junit.Count;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.assertEquals;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestRunSequense
{
    @Test
    public void TestAdd1() {
        int add = new Count().add(2, 5);
        assertEquals(add, 7);
    }

    @Test
    public void TestWord() {
        assertEquals("hi","hello");
    }

}