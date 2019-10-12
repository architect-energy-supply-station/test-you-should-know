package Demo;

import org.junit.Test;
import sun.jvmstat.perfdata.monitor.PerfStringMonitor;

public class TestPrime {
    public static Boolean Prime(int n) {
        for (int i = 1; i < Math.sqrt(n); i++) {
            if (n%i==0) {
                return false;
            }
        }
        return true;

    }

    @Test
    public void testPrime() {
        int n = 7;
        Prime(n);
    }
}
