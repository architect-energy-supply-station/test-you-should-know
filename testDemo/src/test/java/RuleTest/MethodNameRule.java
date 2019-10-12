package RuleTest;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class MethodNameRule implements TestRule {

    @Override
    public Statement apply(Statement statement, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                System.out.println("在测试方法运行之前做一些事情，在statement.evaluate（）之前");

                String className = description.getClassName();
                String methodName = description.getMethodName();
                //运行测试方法
                statement.evaluate();
                System.out.println("在测试之后做一些事情");
                System.out.println("class name" + className + "method name " + methodName);
            }
        };
    }
}
