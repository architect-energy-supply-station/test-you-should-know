package junit5;

import org.junit.jupiter.api.*;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.testng.Assert.assertTrue;

/**
 * @author 任蒙蒙
 * @version 1.0.0
 * @since 2019/10/12 11:39
 */
public class MethodNameRule implements TestRule {
    @Override
    public Statement apply(final Statement base, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                //在测试方法运行之前做一些事情，在base.evaluate()之前
                String className = description.getClassName();
                String methodName = description.getMethodName();

                //运行测试方法
                base.evaluate();

                //在测试方法运行之后做一些事情，在base.evaluate()之后
                System.out.println("Class name:" + className + ", method name: " + methodName);
            }
        };
    }}


