package dawaleDemha;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class loginTest {

    @Test
    void main() {
        // should be able to create a login and validate the username
        Login loginOne = new Login("Ahmed", "1234");

        // validate the username and password getters and setters
        assertEquals("Ahmed", loginOne.getUsername());
        assertEquals(1, loginOne.login("wrongusername", "1234"));
        assertEquals(2, loginOne.login("Ahmed", "wrongpassowrd"));

        // updating password and username
        assertEquals(1, loginOne.setUsername("wrongpassword", "newUsername"));
        assertEquals(0, loginOne.setUsername("1234", "newUsername"));
        assertEquals("newUsername", loginOne.getUsername());
        assertEquals(1, loginOne.setPassword("wrongpassword", "123456"));
        assertEquals(0, loginOne.setPassword("1234", "123456"));
        assertEquals(1, loginOne.login("wrongusername", "123456"));
        assertEquals(2, loginOne.login("newUsername", "wrongpassword"));
        assertEquals(0, loginOne.login("newUsername", "123456"));

        // test that the login has available accounts for interaction
        testCheckingAccountInstance(loginOne);
        testSavingsAccountInstance(loginOne);
    }

    private void testCheckingAccountInstance(Login userAccount) {
        // confirm that the login provides an object storing accounts
        // and methods to interact with them

        int checkingCreatedCode = userAccount.createAccount("Checking");

        // test the account creations
        System.out.println("Created Checking account:");
        assertEquals(0, checkingCreatedCode);
        System.out.println("Passed");

        // assign balances to the account
        int checkingSetCode = userAccount.assignAccountBalance("Checking", 1000);
        int secondAttemptInitChecking = userAccount.assignAccountBalance("Chaking",2000);

        // test for account init codes
        System.out.println("Define checking account balance");
        assertEquals(0, checkingSetCode);
        assertEquals(1, secondAttemptInitChecking);
        System.out.println("Passed");

        // update the account balances
        int debitingCheckingCode = userAccount.debitAccount("Checking", 500);
        int debitedCheckingBalance = userAccount.getAccountBalance("Checking");
        int creditingCheckingCode = userAccount.creditAccont("Checking", 500);
        int creditedCheckingBalance = userAccount.getAccountBalance("Checking");

        System.out.println("Debit and credit Checking:");
        assertEquals(0, debitingCheckingCode);
        assertEquals(0, creditingCheckingCode);
        assertEquals(500, debitedCheckingBalance);
        assertEquals(1000, creditedCheckingBalance);
        System.out.println("Passed");
    }

    private void testSavingsAccountInstance(Login userAccount) {
        // confirm that the login provides an object storing accounts
        // and methods to interact with them

        // init the savings account
        int savingsCreateCode = userAccount.createAccount("Savings");

        // test the account creations
        System.out.println("Created Savings account succesfully:");
        assertEquals(0, savingsCreateCode);
        System.out.println("Passed");

        // assign balances to the account
        int savingsBalanceSet = userAccount.assignAccountBalance("Savings", 1000);
        int secondAttemptSetSavings = userAccount.assignAccountBalance("Savings",2000);

        // test for account init codes
        System.out.println("Init the savings balance:");
        assertEquals(0, savingsBalanceSet);
        assertEquals(1, secondAttemptSetSavings);
        System.out.println("Passed");

        // update the account balances
        int debitSavingsCode = userAccount.debitAccount("Savings", 500);
        int debitedSavingsBalance = userAccount.getAccountBalance("Savings");
        int creditSavingsCode = userAccount.creditAccont("Savings", 500);
        int creditedSavingsBalance = userAccount.getAccountBalance("Savings");

        System.out.println("Debit and credit of Savings:");
        assertEquals(0, debitSavingsCode);
        assertEquals(0, creditSavingsCode);
        assertEquals(500, debitedSavingsBalance);
        assertEquals(1000, creditedSavingsBalance);
        System.out.println("Passed");
    }

}