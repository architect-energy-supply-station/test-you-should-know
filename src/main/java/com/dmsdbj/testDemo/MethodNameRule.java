package com.dmsdbj.testDemo;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * @Classname MethodNameRule
 * @Auther sunshinezhang
 * @Date 2019/10/12 11:29
 */
public class MethodNameRule implements TestRule {

	@Override
	public Statement apply(Statement statement, Description description) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				//在测试方法运行之前做一些事情，在base.evaluate()之前
				String className = description.getClassName();
				String methodName = description.getMethodName();

				//运行测试方法
				statement.evaluate();

				//在测试方法运行之后做一些事情，在base.evaluate()之后
				System.out.println("Class name:"+className+", method name: "+methodName);
			}
		};
	}
}
