package dawaleDemha;

class Account {
    // create an account for a user providing methods to:
    // check balance
    // transact
    // get account type

    private String name;
    private int balance = 0;
    private Boolean balanceIsSet = false;
    private static int numberofAccounts;

    public Account(String accountName) {
        this.name = accountName;
        numberofAccounts++;
    }

    public String getName() {
        return this.name;
    }

    public static int numberOfAccounts() {
        return numberofAccounts;
    }

    public int setBalance(int amount) {
        // set the balance to the amount if the current balance isn't initiated

        int returnCode = 1;
        if (!this.balanceIsSet) {
            this.balance = amount;
            this.balanceIsSet = true;
            returnCode = 0;
        }
        return returnCode;
    }

    public int getBalance() {
        // return the current balance

        return this.balance;
    }

    public int debit(int amount) {
        // debit the amount only if the input is positive
        // return 1 for fail, 0 for success

        int returnCode = 1;
        if (amount >= 0) {
            this.balance-=amount;
            returnCode = 0;
        }
        return returnCode;
    }

    public int credit(int amount) {
        // credit the balance if the input is positive
        // return 1 for fail, 0 for success

        int returnCode = 1;
        if (amount >= 0) {
            this.balance+=amount;
            returnCode = 0;
        }
        return returnCode;
    }


}
