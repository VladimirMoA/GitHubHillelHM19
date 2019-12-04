import org.junit.Test;
import static org.junit.Assert.*;

public class ATMtest {
    private FirstThread firstThread;

    @Test
    public void putTest() {
        ATM.setBankAccount(500);
        assertTrue(firstThread.put(200));
    }

    @Test
    public void withdrawTest() {
        ATM.setBankAccount(500);
        assertTrue(firstThread.withdraw(-400));
    }

    @Test
    public void withdrawTest1() {
        ATM.setBankAccount(500);
        assertFalse(firstThread.withdraw(-600));
    }

}
