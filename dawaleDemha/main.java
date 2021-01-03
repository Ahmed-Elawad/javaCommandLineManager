package dawaleDemha;

import java.util.Scanner;

public class main {
    // prompt the user to create an account and navigate through some settings

    public static void main(String[] args) {

        while (true) {
            int exit;
            System.out.println("Menu\n1) Create user\n2) Exit");
            Scanner userInput = new Scanner(System.in);
            if (userInput.hasNextInt()) {
                exit = userInput.nextInt();
                if (exit == 1) {
                    createUser(userInput);
                }
                if (exit == 2) {
                    System.out.println("Bye");
                    return;
                }
            } else {
                System.out.println("Numbers only.");
            }
        }
    }

    // enter an account and interface with the created accounts
    private static int createUser(Scanner inputProcessor) {

        String username = null;
        String password = null;
        Login userAccount;
        int returnCode = 1;

        username = assignusername(inputProcessor, username);
        password = assignPassword(inputProcessor, password);
        userAccount = new Login(username, password);
        while (true) {
            if (navigateAccount(userAccount, inputProcessor) == 1) break;
        }

        return returnCode;
    }

    private static String assignPassword(Scanner inputProcessor, String password) {
        while (true) {
            System.out.println("Please enter your desired password:");
            inputProcessor.nextLine();
            if (inputProcessor.hasNextLine()) {
                password = inputProcessor.nextLine();
                System.out.format("You entered: %s\n", password);
                System.out.println("Continue to create account?\n1 YES\n2 NO");
                if (inputProcessor.nextInt() == 1) return password;
            }
        }
    }

    private static String assignusername(Scanner inputProcessor, String username) {
        while (true) {
            System.out.println("Please entered the desired username:");
            inputProcessor.nextLine();
            if (inputProcessor.hasNextLine()) {
                username = inputProcessor.nextLine();
                System.out.format("You entered: %s\n", username);
                System.out.println("Continue to password?\n1 YES\n2 NO");
                if (inputProcessor.nextInt() == 1) return username;
            }
        }
    }

    private static int navigateAccount(Login userAccount, Scanner inputScanner) {
        int returnCode = 0;
        Boolean accountsCreated = false;
        while (!accountsCreated) {
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

        returnCode = 1;
        return returnCode;
    }

    private static int openAccount(Scanner inputScanner, Login userAccount, String account) {
        // provide options to update account balances
        // return 1 always

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
