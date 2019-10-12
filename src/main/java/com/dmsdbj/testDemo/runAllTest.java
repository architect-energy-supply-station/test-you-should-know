package com.dmsdbj.testDemo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @Classname runAllTest
 * @Auther sunshinezhang
 * @Date 2019/10/12 10:55
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
		CountTest.class,
		TestFixture.class,
		AssertTest.class,
		TestRunSequence.class
})
public class runAllTest {

}
