package ru.someboy.nvacenter;

public final class DebitCardWithInterest extends DebitCard {
    private double interestRate;

    public DebitCardWithInterest(double balance) {
        super(balance);
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        interestRate += amount * 0.00005;
        balance += interestRate;
        getBalanceInfo(interestRate);
    }

    public void getAllBalanceInfo() {
        super.getAllBalanceInfo();
        System.out.println("Из них накопления: " + interestRate);
    }

    public void getBalanceInfo(double interestRate) {
        System.out.println("А так же накопления: " + interestRate);
    }
}

