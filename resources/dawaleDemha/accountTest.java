package dawaleDemha;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class accountTest {

    private void testChecking(Account checking) {
        // update the balances for each account
        // checking
        assertEquals(0, checking.setBalance(1000));
        assertEquals(1, checking.setBalance(1000));
        assertEquals(1000, checking.getBalance());
        assertEquals(1, checking.debit(-500));
        assertEquals(0, checking.debit(500));
        assertEquals(500, checking.getBalance());
        assertEquals(1, checking.credit(-500));
        assertEquals(0, checking.credit(500));
        assertEquals(1000, checking.getBalance());

    }

    private void testSavings(Account savings) {
        // update the balances for each account
        // savings
        assertEquals(0, savings.setBalance(1000));
        assertEquals(1, savings.setBalance(1000));
        assertEquals(1000, savings.getBalance());
        assertEquals(1, savings.debit(-500));
        assertEquals(0, savings.debit(500));
        assertEquals(500, savings.getBalance());
        assertEquals(1, savings.credit(-500));
        assertEquals(0, savings.credit(500));
        assertEquals(1000, savings.getBalance());
    }

    @Test
    void main() {
        // test that a new account is created with a balance

        Account checking = new Account("Checking");
        Account savings = new Account("Savings");

        // validate two account creations and a tracker for the number of accounts
        System.out.println("Testing that a checking and savings account were created:");
        assertEquals("Checking", checking.getName());
        assertEquals("Savings", savings.getName());
        System.out.println("passed");

        System.out.println("Testing global tracking for 2 accounts created:");
        assertEquals(2, Account.numberOfAccounts());
        System.out.println("Passed");

        System.out.println("testing checking instance methods:");
        testChecking(checking);
        System.out.println("Passed");

        System.out.println("Testing savings instance methods:");
        testSavings(savings);
        System.out.println("passed");

    }

}