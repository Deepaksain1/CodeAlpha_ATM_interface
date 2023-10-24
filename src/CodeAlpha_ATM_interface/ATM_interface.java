package CodeAlpha_ATM_interface;
import java.util.Scanner;

    class BankAccount {
        private double balance;

        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }
        public double getBalance(){
            return balance;
        }
        public void deposite(double amount){
            if (amount > 0){
                balance += amount;
                System.out.println("Deposite successfully. New balance is :=" + balance);
            } else {
                System.out.println("Invalid amount for deposite.");
            }
        }

        public void withdraw(double amount){
            if(amount > 0 && amount <= balance){
                balance -= amount;
                System.out.println("Withdrawal successful. New balance := " + balance);
            } else {
                System.out.println("Insufficient fund or invalid amount for withdrawal.");
            }
        }

        public void transfer(double amount) {
            if(amount > 0 && amount <= balance){
                balance -= amount;
                System.out.println("Transfer successful. New balance := " + balance);
            } else {
                System.out.println("Insufficient fund or invalid amount for Transfer.");
            }
        }
    }

    class ATM{
        private BankAccount account;
        private Scanner scanner;

        public ATM(BankAccount account){
            this.account = account;
            this.scanner =new Scanner(System.in);
        }

        public void showMenu() {
            System.out.println("1. Check balance.");
            System.out.println("2. Deposite.");
            System.out.println("3. Withdraw.");
            System.out.println("4. Transfer.");
            System.out.println("5. Exit.");
        }

        public void run(){
            int choice;
            do {
                showMenu();
                System.out.println("-------------------------------");
                System.out.println("Enter your choice:");
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        checkBalance();
                        break;
                    case 2:
                        deposite();
                        break;
                    case 3:
                        withdraw();
                    case 4:
                        transfer();
                        break;
                    case 5:
                        System.out.println("Thank you for using the ATM");
                        break;

                    default:
                        System.out.println("Invalid choice. Please select a valide option.");
                }
            } while (choice != 5);
        }

        private void checkBalance(){
            System.out.println("-------------------------------");
            System.out.println("Your current balance is: " + account.getBalance());
            System.out.println("-------------------------------");
        }

        private void deposite(){
            System.out.println("-------------------------------");
            System.out.println("Enter the amount to deposite:" );
            System.out.println("-------------------------------");
            double amount = scanner.nextDouble();
            account.deposite(amount);
        }

        private void withdraw(){
            System.out.println("-------------------------------");
            System.out.println("Enter the amount to withdraw:  ");
            System.out.println("-------------------------------");
            double amount = scanner.nextDouble();
            account.withdraw(amount);
        }

        private void transfer(){
            System.out.println("-------------------------------");
            System.out.println("Enter amount for transfer: ");
            System.out.println("-------------------------------");
            double amount = scanner.nextDouble();
            account.transfer(amount);
        }
    }

    class ATM_Interface{
        public static void main(String[] args){
            System.out.println("-------------------------------");
            System.out.println("Welcome to the ATM            | ");
            System.out.println("-------------------------------");
            Scanner sc =new Scanner(System.in);
            System.out.println("Enter your four digit PIN     |");
            System.out.println("-------------------------------");
            int enteredPin = sc.nextInt();

            BankAccount userAccount = new BankAccount((1000.00));
            ATM atm = new ATM(userAccount);
            atm.run();
        }
    }

