package com.dmsdbj.testDemo;


import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @Classname CountTEst
 * @Auther sunshinezhang
 * @Date 2019/10/12 09:41
 */
public class CountTest {

	@Test
	public void testAdd(){
		Count count = new Count();
		int result = count.add(2, 2);
		assertEquals(result,4);
	}


	@Test(timeout = 100)
	public void testAddTimeOut() throws InterruptedException {
		Thread.sleep(101);
		new Count().add(1, 1);
	}

	@Test(expected = ArithmeticException.class)
	public void testDivision(){
		new Count().division(8, 0);
	}

	@Test
	@Ignore
	public void testAdd1(){
		int result = new Count().add(2, 2);
		assertEquals(result,5);
	}


}
