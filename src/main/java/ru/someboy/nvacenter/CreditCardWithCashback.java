package ru.someboy.nvacenter;

public final class CreditCardWithCashback extends CreditCard {
    private double cashback;

    public CreditCardWithCashback(double balance) {
        super(balance);
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
    }

    @Override
    public boolean pay(double amount) {
        boolean success = super.pay(amount);
        if (success && amount >= 5000) {
            cashback+= amount * 5/100;
            balance += cashback;
            getBalanceInfo(cashback);
        }else {
            System.out.print(appeal);
        }
        return success;
    }

    public void getAllBalanceInfo() {
        super.getAllBalanceInfo();
        System.out.println("Из них кешбэк: " + cashback);
    }

    public void getBalanceInfo(double cashback) {
        System.out.println("А так же кешбэк: " + cashback);
    }
}
