import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by wushbin on 6/15/17.
 */
public class FlikTest {
    @Test
    public void testIsSameNumber(){
        int a = 1;
        int b = 1;
        int c = 2;
        assertTrue(Flik.isSameNumber(a,b));
        assertTrue(! Flik.isSameNumber(a,c));
    }
    public static void main(String... args) {
        jh61b.junit.TestRunner.runTests("all", FlikTest.class);
    }
}
