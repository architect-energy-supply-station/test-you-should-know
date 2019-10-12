package JunitTest;

//import JunitTwo.Count;
import Junit.Count;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class JunitTwoCountTest {
    //测试超时
    @Test(timeout=100)    public void TestAdd() throws InterruptedException {
        Thread.sleep(101);
        Count count = new Count();
        count.add(2, 2);

    }

    //测试异常
    @Test(expected=ArithmeticException.class)
    public void TestDivision() {

        new Count().division(8, 0);
    }

    //跳过该用例
    @Ignore
    @Test
    public void TestAdd1() {
        int add = new Count().add(2, 2);
        assertEquals(add, 5);
    }

}