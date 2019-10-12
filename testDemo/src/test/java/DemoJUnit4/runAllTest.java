package DemoJUnit4;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({CountTest.class, JunitDemo.class, TestFixture.class, TestPrime.class})

public class runAllTest {

}
