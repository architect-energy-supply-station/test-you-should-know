package com.dmsdbj.testDemo;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Classname FirstJUnit5Tests
 * @Auther sunshinezhang
 * @Date 2019/10/12 11:09
 */
class FirstJUnit5Tests {

	@Test
	 void myFirstTest() {
		assertEquals(2, 1 + 1);
	}
}
