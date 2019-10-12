import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * @author 任蒙蒙
 * @version 1.0.0
 * @since 2019/10/12 11:39
 */
public class MethodNameRule implements TestRule {
    @Override
    public Statement apply(Statement base, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                String className = description.getClassName();
                String methodName = description.getMethodName();
                base.evaluate();
                System.out.println("Class name:"+className+", method name: "+methodName);
            }
        };
    }
}
