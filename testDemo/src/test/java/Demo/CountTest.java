package Demo;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountTest {
//    @Test
//    public void addTest() {
//        Count count = new Count();
//        int result = count.add(4, 5);
//        assertEquals(result,9);
//    }

    //验证超时
    @Test(timeout = 200)
    public void testAdd() throws InterruptedException {
        Thread.sleep(101);
        new Count().add(1, 1);
    }

    //    验证抛出异常
    @Test(expected = ArithmeticException.class)
    public void testDivision() {
        new Count().division(0, 0);
    }

    //    跳过该用例
    public void testAdd2() {
        assertEquals(new Count().add(2,2),5);
    }
}

