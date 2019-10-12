package com.dmsdbj.testDemo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

/**
 * @Classname RuleTestDemo
 * @Auther sunshinezhang
 * @Date 2019/10/12 11:27
 */
public class RuleTestDemo {
	//使用Timeout这个Rule
	@Rule
	public Timeout timeout = new Timeout(1000);


	@Rule
	public MethodNameRule methodNameRule=new MethodNameRule();

	@Test
	public void testMethod1() throws InterruptedException {
		Thread.sleep(1001);
	}

	@Test
	public void testMethod2() throws InterruptedException {
		Thread.sleep(999);
	}

}
