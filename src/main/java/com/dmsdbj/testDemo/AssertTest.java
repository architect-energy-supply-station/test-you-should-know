package com.dmsdbj.testDemo;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @Classname AssertTest
 * @Auther sunshinezhang
 * @Date 2019/10/12 10:12
 */
public class AssertTest {

	/**
	 * 判断一个数是否为素数
	 */
	public static Boolean Prime(int n){
		for (int i = 2; i < Math.sqrt(n); i++) {
			if (n % i==0) {
				//判断为素数
				return false;
			}
		}
		//判断不为素数
		return true;
	}

	@Test
	public void testPrime(){
		int n = 7;
		assertTrue(AssertTest.Prime(n));
	}
}
