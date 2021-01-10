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
        /**
         * @Returns {String} Returns the saved username
         */

        return this.username;
    }

    private Boolean validatePassword(String inputPassword) {
        /**
         * @Params {String} (passwordToValidate)
         * Confirm if the inputed password has the same length
         * and charecters as the saved password
         * @Returns {true} password match {false} password fail
         */

        if (inputPassword.length() != this.password.length()) return false;
        boolean correctPassword = this.password.equals(inputPassword);
        return correctPassword;
    }

    private Boolean validateUsername(String username) {
        /**
         * @Params {String} (usernameToValidate)
         * Confirm if the inputed username matches the
         * saved username by length and charecters
         * @Returns {true} success {false} fail
         */

        if (username.length() != this.username.length()) return false;
        boolean correctUsername = this.username.equals(username);
        return correctUsername;
    }

    public int login(String username, String password) {
        /**
         * @Params {String(username), String(Password)}
         * Validate the inputed login credentials using the
         * private validator methods
         * @Returns {Int} 1: failed username, 2: failed Password, 0 success
         */

        Boolean isCorrectUsername = validateUsername(username);
        Boolean isCorrectPass = validatePassword(password);
        if (!isCorrectUsername) return 1;
        if (!isCorrectPass) return 2;
        return 0;
    }

    public int setUsername(String password, String username) {
        /**
         * @Params {String(password), String(username)}
         * Validate the provided password using the private
         * validator and set the new username on success
         * @Returns {int} 1: failed validation, 0: success
         */

        Boolean isCorrectPass = validatePassword(password);
        if (isCorrectPass) {
            this.username = username;
            return 0;
        }
        return 1;
    }

    public int setPassword(String oldPassword, String newPassword) {
        /**
         * @Params {String(oldPass), String(newPass)}
         * Validate the password using private methods and
         * update the password on success
         * @Returns {int} 1: failed validation, 0: successful assignment
         */

        Boolean isCorrectPassword = validatePassword(oldPassword);
        if (isCorrectPassword) {
            this.password = newPassword;
            return 0;
        }
        return 1;
    }

    public int numberOfAccounts() {
        return this.accounts.length;
    }

    public int createAccount(String name) {
        /**
         * @Params {String(name)}
         * Creates a new account on the Login obj
         * assigning the account name to the passed in name
         * only if there are less than 3 accounts created.
         * 2 is the max.
         * @Returns {int} 1: failed creation. No message.
         * 0: for successful creation.
         */

        if (this.lastCreatedAccountIndex <= 1) {
            accounts[this.lastCreatedAccountIndex] = new Account(name);
            this.lastCreatedAccountIndex++;
            return 0;
        }
        return 1;
    }

    public int assignAccountBalance(String accountName, int amount) {
        /**
         * @Params {String(accountname), int(transactionAmount)}
         * Set the balance for the requested account validating the
         * instance location by the accountName.
         * @Returns {int}
         * accounts[index].setBalance returns 1 for fail, 0 for success
         * On a request to a non existing account 1 is returned w/o
         * message
         */

        if (accountName.equals("Checking")) {
            return accounts[0].setBalance(amount);
        } else if (accountName.equals("Savings")) {
            return accounts[1].setBalance(amount);
        }
        return 1;
    }

    public int debitAccount(String accountName, int amount) {
        /**
         * @Params {String(accountname), int(transactionAmount)}
         * Debit the balance for the requested account validating the
         * instance location by the accountName.
         * @Returns {int}
         * accounts[index].debit returns 1 for fail, 0 for success
         * On a request to a non existing account 1 is returned w/o
         * message
         */

        if (accountName.equals("Checking")) {
            return accounts[0].debit(amount);
        } else if(accountName.equals("Savings")) {
            return accounts[1].debit(amount);
        }
        return 1;
    }

    public int creditAccont(String accountName, int amount) {
        /**
         * @Params {String(accountname), int(transactionAmount)}
         * Credit the balance for the requested account validating the
         * instance location by the accountName.
         * @Returns {int}
         * accounts[index].credit returns 1 for fail, 0 for success
         * On a request to a non existing account 1 is returned w/o
         * message
         */

        if (accountName.equals("Checking")) {
            return accounts[0].credit(amount);
        } else if (accountName.equals("Savings")) {
            return accounts[1].credit(amount);
        }
        return  1;
    }

    public int getAccountBalance(String accountName) {
        /**
         * @Params {String(accountName)}
         * Return  the balance for the provided name
         * @Returns {int} account balance
         * If account isn't found return -1
         */

        if (accountName.equals("Checking")) {
            return accounts[0].getBalance();
        } else if (accountName.equals("Savings")) {
            return accounts[1].getBalance();
        }
        return -1;
    }

}
