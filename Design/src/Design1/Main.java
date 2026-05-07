package Design1;

public class Main {
    abstract static class Account {
        private String accountNumber;
        private Double balance;
        Account(String accountNumber, Double balance) {
            this.accountNumber = accountNumber;
            this.balance = balance;
        }
        public void deposit(Double amount) {
            balance += amount;
            IO.println("Deposited : " + amount + " and Total Balance : "+ balance);
        }
        public void withdraw(Double amount) {
            if(amount > balance) {
                IO.println("Insufficient Balance");
            }
            else {
                balance -= amount;
                IO.println("Withdrawn : " + amount + " and Total Balance : "+ balance);
            }
        }
        abstract void calculateInterest();

        public String getAccountNumber() {
            return accountNumber;
        }

        public void setAccountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
        }

        public Double getBalance() {
            return balance;
        }

        public void setBalance(Double balance) {
            this.balance = balance;
        }
    }
    public static class SavingsAccount extends Account {
        SavingsAccount(String accountNumber, Double balance) {
            super(accountNumber, balance);
        }
        @Override
        void calculateInterest() {
            Double balance = getBalance();
            balance *= 0.05;
            IO.println("Saving Account Interest : "+balance);
        }
    }
    public static class CurrentAccount extends Account {
        CurrentAccount(String accountNumber, Double balance) {
            super(accountNumber, balance);
        }
        @Override
        void calculateInterest() {
            IO.println("Current Account have no Interest");
            Double balance = getBalance();
            if(balance < 1000) IO.println("Balance less than 1000");
        }
    }
    public static void main(String[] args) {
        Account account1 = new SavingsAccount("Savings Account", 100.0);
        account1.deposit(200.0);
        account1.withdraw(150.0);
        account1.calculateInterest();

        Account account2 = new CurrentAccount("Current Account", 1000.0);
        account2.deposit(200.0);
        account2.withdraw(150.0);
        account2.calculateInterest();
    }
}
