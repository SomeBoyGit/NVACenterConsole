package ru.someboy.nvacenter;

public abstract class BankCard {
    protected double balance;
    protected final String exceptionInput = "Ошибка: Нельзя %s отрицательную сумму.";
    protected final String exceptionInsufficientFunds = "Ошибка: Недостаточно средств.\n";
    protected final String depositedOnCard = "Карта пополнена: +%s.\n";
    protected final String paidByCard = "Оплата прошла успешно: -%s.\n";
    protected final String appeal = "Начните зарабатывать! При покупках от 5000 мы возвращаем вам 5%.\n";


    public BankCard(double balance) {
        this.balance = balance;
    }

    public abstract void deposit(double amount);

    public abstract boolean pay(double amount);

    public abstract void getBalanceInfo();

    public abstract void getAllBalanceInfo();

    public String rounding (double amount) {
        return String.format("%.2f", amount);
    }
}
