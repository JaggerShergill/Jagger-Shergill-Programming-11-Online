import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static junit.framework.TestCase.assertEquals;

public class TestingClass {
    Customer test;
    ArrayList<Deposit> deposits;
    ArrayList<Withdraw> withdraws;
    Date newDate = new Date();


    @Before
    public void setup(){
        test = new Customer("Jermaine", 100, 1000, 1000);

    }

    @Test
    public void testCustomerDeposit (){
        assertEquals(1000.0, test.getCheckBalance());
        assertEquals(1000.0, test.getSavingBalance());
        test.deposit(100, newDate, "Checking");
        assertEquals(1100.0, test.getCheckBalance());
        assertEquals(1000.0, test.getSavingBalance());
    }

    @Test
    public void testCustomerWithdraw (){
        assertEquals(1000.0, test.getCheckBalance());
        assertEquals(1000.0, test.getSavingBalance());
        test.withdraw(100, newDate, "Saving");
        assertEquals(1000.0, test.getCheckBalance());
        assertEquals(900.0, test.getSavingBalance());
    }

    @Test
    public void testDepositToString (){
        test.deposit(100, newDate, "Checking");
        assertEquals(test.getDeposit(), "[Deposit of: $100.0 Date: " + newDate + " into account: Checking]");
    }

    @Test
    public void testWithdrawToString (){
        test.withdraw(100, newDate, "Saving");
        assertEquals(test.getWithdraw(),"[Withdraw of: $100.0 Date: " + newDate + " into account: Saving]");
    }
}
