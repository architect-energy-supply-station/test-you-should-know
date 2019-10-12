package Junit5Test;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class MethodNameRule implements TestRule {
    public Statement apply(final Statement statement, final Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                String className = description.getClassName();
                String methodName = description.getMethodName();
                statement.evaluate();
                System.out.println("className" + className + "methodName" + methodName);

            }
        };
    }
//    public Statement apply(final Statement statement, final Description description) {
//        return new Statement() {
//            @Override
//            public void evaluate() throws Throwable {
//                String className = description ();
//                String methodName = description.getMethodName();
//                statement.evaluate();//运行测试方法
//
//            }
//        };
//    }
}