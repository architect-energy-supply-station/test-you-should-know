package com.dmsdbj.testDemo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @Classname JUnit5NewTests
 * @Auther sunshinezhang
 * @Date 2019/10/12 11:15
 */
public class JUnit5NewTests {

	@BeforeEach
	@DisplayName("每条用例开始时执行")
	public void start(){
		System.out.println("每条用例开始时执行");
	}

	@AfterEach
	@DisplayName("每条用例结束时执行")
	public void end(){
		System.out.println("每条用例结束时执行");
	}

	@Test
	public void myFirstTest(){
		assertEquals(2,1+1);
	}

	@Test
	@DisplayName("描述测试用例╯°□°）╯")
	public void testWithDisplayName(){
		System.out.println("描述测试用例╯°□°）╯");
	}

	@Test
	@Disabled("这条用例暂时跑不过，忽略!")
	public void myFailTest(){
		assertEquals(1, 3);
	}

	@Test
	@DisplayName("运行一组断言")
	public void assertAllCase1(){
		assertAll("groupAssert",
				() -> assertEquals(2, 1 + 1),
				() -> assertTrue(1 > 0));
	}

	@Test
	@DisplayName("依赖注入1")
	public void testInfo(final  TestInfo testInfo){
		System.out.println(testInfo.getDisplayName());
	}

	@Test
	@DisplayName("依赖注入2")
	public void testReporter(final TestReporter testReporter){
		testReporter.publishEntry("name","sunshine");
	}


}
