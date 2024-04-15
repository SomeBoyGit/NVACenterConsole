package ru.someboy.nvacenter;

public class DebitCard extends BankCard {

    public DebitCard(double balance) {
        super(balance);
    }

    @Override
    public void deposit(double amount) {
        if (amount < 0) {
            System.out.printf(exceptionInput, "внести");
        } else {
            balance += amount;
            System.out.printf(depositedOnCard, rounding(amount));
            getBalanceInfo();
        }
    }

    @Override
    public boolean pay(double amount) {
        if (amount < 0) {
            System.out.printf(exceptionInput, "оплатить");
            return false;
        }
        if (balance >= amount) {
            balance -= amount;
            System.out.printf(paidByCard, rounding(amount));
            getBalanceInfo();
            return true;
        } else {
            System.out.print(exceptionInsufficientFunds);
            getBalanceInfo();
            return false;
        }
    }

    public void getBalanceInfo() {
        System.out.println("Собственные средства: " + balance);
    }

    @Override
    public void getAllBalanceInfo() {
        System.out.println("Собственные средства: " + balance);
    }
}
