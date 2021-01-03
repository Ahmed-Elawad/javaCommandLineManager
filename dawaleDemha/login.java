package dawaleDemha;

class Login {
    // create a login class allowing users to define login credentials
    private String username;
    private String password;
    private Account[] accounts = new Account[2];
    private int lastCreatedAccountIndex = 0;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        // return the saved username

        return this.username;
    }

    private Boolean validatePassword(String inputPassword) {
        // validate the input password witht the saved password
        // return true for success false for fail

        if (inputPassword.length() != this.password.length()) return false;
        for (int i = 0; i < this.password.length(); i++) {
            if (this.password.charAt(i) != inputPassword.charAt(i)) return false;
        }
        return true;
    }

    private Boolean validateUsername(String username) {
        // validate the input username with the saved username
        // returns: false for fail, true for success

        if (username.length() != this.username.length()) return false;
        for (int i = 0; i < this.username.length(); i++) {
            if (this.username.charAt(i) != username.charAt(i)) return false;
        }
        return true;
    }

    public int login(String username, String password) {
        // validate the username and password
        // returns: 0 for success, 1 for wrong username, 2 for wrong password

        int returnCode = 0;
        Boolean isCorrectUsername = validateUsername(username);
        Boolean isCorrectPass = validatePassword(password);
        if (!isCorrectUsername) returnCode = 1;
        if (!isCorrectPass) returnCode = 2;
        return returnCode;
    }

    public int setUsername(String password, String username) {
        // validate the password provided and reset the username if so
        // returns 0 for success, 1 for fail

        int returnCode = 1;
        Boolean isCorrectPass = validatePassword(password);
        if (isCorrectPass) {
            this.username = username;
            returnCode = 0;
        }
        return returnCode;
    }

    public int setPassword(String oldPassword, String newPassword) {
        // validate the password
        // returns 1 for fail, 0 for success

        int returnCode = 1;
        Boolean isCorrectPassword = validatePassword(oldPassword);
        if (isCorrectPassword) {
            this.password = newPassword;
            returnCode = 0;
        }
        return returnCode;
    }

    public int numberOfAccounts() {
        return this.accounts.length;
    }

    public int createAccount(String name) {
        // create a new account at the most recent availible index

        int returnCode = 1;
        if (this.lastCreatedAccountIndex <= 1) {
            accounts[this.lastCreatedAccountIndex] = new Account(name);
            this.lastCreatedAccountIndex++;
            returnCode = 0;
        }
        return returnCode;
    }

    public int assignAccountBalance(String accountName, int amount) {
        // assign the proper account balance

        if (accountName == "Checking") {
            return accounts[0].setBalance(amount);
        } else if (accountName == "Savings") {
            return accounts[1].setBalance(amount);
        }
        return 1;
    }

    public int assignSavingsBalance(int amount) {
        return accounts[1].setBalance(amount);
    }

    public int debitAccount(String accountName, int amount) {
        // send the request to the proper account instance and return the
        // result of the call

        int returnCode = 0;
        if (accountName == "Checking") {
            returnCode = accounts[0].debit(amount);
        } else if(accountName == "Savings"){
            returnCode = accounts[1].debit(amount);
        }
        return returnCode;
    }

    public int creditAccont(String accountName, int amount) {
        // process the transaction for the requested account
        // return 1 for fail, 0 for success

        int returnCode = 1;
        if (accountName == "Checking") {
            returnCode = accounts[0].credit(amount);
        } else if (accountName == "Savings") {
            returnCode = accounts[1].credit(amount);
        }
        return  returnCode;
    }

    public int getAccountBalance(String accountName) {
        // get the balance for the account and return the  amount
        // returns balance if found, -1 for fail(need to handle this later)

        int balance = -1;
        if (accountName == "Checking") {
            balance = accounts[0].getBalance();
        } else if (accountName == "Savings") {
            balance = accounts[1].getBalance();
        }
        return balance;
    }

}
