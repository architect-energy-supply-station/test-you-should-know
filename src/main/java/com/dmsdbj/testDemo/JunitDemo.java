package com.dmsdbj.testDemo;


import org.junit.Test;
import static org.junit.Assert.assertEquals;


/**
 * @Classname JunitDemo
 * @Auther sunshinezhang
 * @Date 2019/10/12 09:37
 */
public class JunitDemo {

	@Test
	public void myFirstTest(){
		assertEquals(2+2, 4);
	}
}
