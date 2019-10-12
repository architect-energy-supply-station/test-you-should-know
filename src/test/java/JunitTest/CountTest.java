package JunitTest;


//import Junit.Count;
import Junit.Count;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountTest {
    @Test
    public void TestAdd() {
        Count count = new Count();
        int add = count.add(2, 2);
        assertEquals(add, 4);
    }



}