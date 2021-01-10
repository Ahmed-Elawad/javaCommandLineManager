package dawaleDemha;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        while (true) {
            int exit;
            System.out.println("Menu\n1) Create user\n2) Exit");
            Scanner userInput = new Scanner(System.in);
            if (userInput.hasNextInt()) {
                exit = userInput.nextInt();
                if (exit == 1) {
                    createUser(userInput);
                } else if (exit == 2) {
                    System.out.println("Bye");
                    return;
                }
            } else {
                System.out.println("Numbers only.");
            }
        }
    }

    private static int createUser(Scanner inputProcessor) {
        /**
         * @Params {Scanner} (inputProcesserObj)
         * Assign the username and password calling assignPassword() & assignUsername()
         * Create a new Login instance using username and password and
         * enter the interface to interact with each account
         * @Returns {Int} once interface is exited return 1
         * @implNote Cannot return to created instance once exited
         */

        String username;
        String password;
        Login userAccount;
        int returnCode = 1;

        username = assignusername(inputProcessor);
        password = assignPassword(inputProcessor);
        userAccount = new Login(username, password);
        while (true) {
            if (navigateAccount(userAccount, inputProcessor) == 1) break;
        }

        return returnCode;
    }

    private static String assignPassword(Scanner inputProcessor) {
        /**
         * @Params {Scanner, String) (inputProcessingObj, passwordRef)
         * Provide the INT interface to input and assign the password
         * @Returns {String} returns the assigned passsword String obj
         * NOTE: Cannot exit interface once entered
         */

        while (true) {
            System.out.println("Please enter your desired password:");
            inputProcessor.nextLine();
            if (inputProcessor.hasNextLine()) {
                String password = inputProcessor.nextLine();
                System.out.format("You entered: %s\n", password);
                System.out.println("Continue to create account?\n1 YES\n2 NO");
                if (inputProcessor.nextInt() == 1) return password;
            }
        }
    }

    private static String assignusername(Scanner inputProcessor) {
        /**
         * @Params {Scanner, String) (inputProcessingObj, usernameRef)
         * Provide the INT interface to input and assign the username
         * @Returns {String} returns the assigned username String obj
         * NOTE: Cannot exit interface on request
         */

        while (true) {
            System.out.println("Please entered the desired username:");
            inputProcessor.nextLine();
            if (inputProcessor.hasNextLine()) {
                String username = inputProcessor.nextLine();
                System.out.format("You entered: %s\n", username);
                System.out.println("Continue to password?\n1 YES\n2 NO");
                if (inputProcessor.nextInt() == 1) return username;
            }
        }
    }

    private static int navigateAccount(Login userAccount, Scanner inputScanner) {
        /**
         * @Params {Login, Scanner} (accountObj, inputProcessor)
         * Provide the interface for a user to interact with the newly
         * created account through INT inputs and navigation.
         * @Returns {Int} 1 for succesful termination
         * @Note: Once exited cannot return
         */

        while (true) {
            int exit;
            System.out.println("Need to create an account before moving on:\nCreating Checking");
            System.out.println("Please enter balance in checking:");
            int checkingBalance = inputScanner.nextInt();
            userAccount.createAccount("Checking");
            exit = userAccount.assignAccountBalance("Checking", checkingBalance);
            if (exit == 0) {
                System.out.println("Checking account created.\n\n");
                break;
            }
        }

        while (true) {
            int userNav;
            System.out.println("Accounts options");
            System.out.println("1. Access Checking\n2. Access Savings\n3. Exit");
            userNav = inputScanner.nextInt();
            if (userNav == 1) {
                userNav = openAccount(inputScanner, userAccount, "Checking");
            } else if (userNav == 2) {
                userNav = openAccount(inputScanner, userAccount, "Savings");
            } else if (userNav == 3) break;
            if (userNav == 0) break;
        }

        return 1;
    }

    private static int openAccount(Scanner inputScanner, Login userAccount, String account) {
        /**
         * @params {Scanner, String, String} (inputProcesser, userAccountObject, accountName)
         * Provides an option menu to interact with the account obj:
         * Debit: reduce the balance,
         * Credit: Increase the balance,
         * Return: returns to account selection menu
         * @returns: 1 for successful exit
         */

        int returnCode = 1;
        while (true) {
            int userInput;
            System.out.format("\nOptions:\n1. Check %s Balance\n2. Debit Checking\n3. Credit Checking\n4. Return to accounts\nSelection: ", account);
            userInput = inputScanner.nextInt();
            if (userInput == 1) {
                System.out.format("\n%s balance: %d\n\n", account, userAccount.getAccountBalance(account));
            } else if (userInput == 2) {
                int debit;
                System.out.println("\nEnter debit amount:");
                debit = inputScanner.nextInt();
                userAccount.debitAccount(account, debit);
                System.out.format("New balance is: %d\n", userAccount.getAccountBalance(account));
            } else if (userInput == 3) {
                int credit;
                System.out.println("\nEnter credit amount:");
                credit = inputScanner.nextInt();
                userAccount.creditAccont(account, credit);
                System.out.format("\nNew balance is: %d", userAccount.getAccountBalance(account));
            } else if (userInput == 4) {
                break;
            }
        }

        return returnCode;
    }

}
