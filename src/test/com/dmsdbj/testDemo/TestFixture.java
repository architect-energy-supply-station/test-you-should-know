package com.dmsdbj.testDemo;

import com.dmsdbj.testModel.Count;
import org.junit.*;

import static org.junit.Assert.assertEquals;

/**
 * @Classname TestFixture
 * @Auther sunshinezhang
 * @Date 2019/10/12 10:01
 */
public class TestFixture {

	//在当前测试类开始时运行。

	@BeforeClass
	public static void beforeClass(){
		System.out.println("-------------------beforeClass");
	}


	//在当前测试类结束时运行。
	@AfterClass
	public static void afterClass(){
		System.out.println("-------------------afterClass");

	}


	//每个测试方法运行之前运行
	@Before
	public void before(){
		System.out.println("=====before");
	}

	//每个测试方法运行之后运行
	@After
	public void after(){
		System.out.println("=====after");
	}

	@Test
	public void testAdd(){
		int result = new Count().add(4, 6);
		assertEquals(10,result);
		System.out.println("test Run testadd");
	}


	@Test
	public void testAdd1(){
		int result = new Count().add(13, 15);
		assertEquals(28, result);
		System.out.println("test Run testadd1");

	}

}
