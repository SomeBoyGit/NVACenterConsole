package ru.someboy.nvacenter;

public class CreditCard extends BankCard {
    private final double creditLimit = 10_000;
    private double creditBalance = creditLimit;

    public CreditCard(double balance) {
        super(balance);
    }

    @Override
    public void deposit(double amount) {
        if (amount < 0) {
            System.out.printf(exceptionInput, "внести");
            return;
        }
        if (creditBalance + amount <= creditLimit) {
            creditBalance += amount;
        } else {
            if(creditBalance == creditLimit) {
                balance += amount;
            } else {
                double remainingAmount = creditLimit - creditBalance;
                creditBalance = creditLimit;
                balance += amount - remainingAmount;
            }
        }
        System.out.printf(depositedOnCard, rounding(amount));
        getBalanceInfo();
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
        } else if (creditBalance + balance >= amount) {
            double remainingAmount = amount - balance;
            balance = 0;
            creditBalance -= remainingAmount;
            System.out.printf(paidByCard, rounding(amount));
            getBalanceInfo();
            return true;
        } else {
            System.out.print(exceptionInsufficientFunds);
            getBalanceInfo();
            return false;
        }
    }


    @Override
    public void getBalanceInfo() {
        System.out.println("Средства на карте: " + (creditBalance + balance));
    }

    @Override
    public void getAllBalanceInfo() {
        System.out.println("Кредитные средства: " + creditBalance);
        System.out.println("Собственные средства: " + balance);
    }
}
