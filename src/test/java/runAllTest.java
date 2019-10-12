import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author 任蒙蒙
 * @version 1.0.0
 * @since 2019/10/12 11:19
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        CountTest.class,
        TestFixture.class,
        AssertTest.class,
        TestRunSequence.class,
})
public class runAllTest {

}
