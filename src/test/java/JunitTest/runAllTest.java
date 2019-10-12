package JunitTest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CountTest.class,
        Fixture.class,
        AssertTest.class,
        TestRunSequense.class,
})
public class runAllTest {
}