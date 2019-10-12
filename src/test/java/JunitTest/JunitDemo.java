package JunitTest;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JunitDemo {
    @Test
    public void MyfirstTest() {
        assertEquals(2 + 2, 4);
    }

}