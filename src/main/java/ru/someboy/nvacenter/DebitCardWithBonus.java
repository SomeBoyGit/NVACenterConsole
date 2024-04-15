package ru.someboy.nvacenter;

public final class DebitCardWithBonus extends DebitCard {
    private int bonusPoints;

    public DebitCardWithBonus(double balance) {
        super(balance);
    }

    public void earnBonusPoints(double amount) {
        super.deposit(amount);
        bonusPoints += (int) (amount * 0.01);
        getBalanceInfo(bonusPoints);
    }

    public void getAllBalanceInfo() {
        super.getAllBalanceInfo();
        System.out.println("Из них: " + bonusPoints);
    }

    public void getBalanceInfo(double bonusPoints) {
        System.out.println("А так же накопления: " + bonusPoints);
    }
}