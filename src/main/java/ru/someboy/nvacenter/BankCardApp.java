package ru.someboy.nvacenter;

import java.util.Scanner;

public class BankCardApp {
    private static final String replenishment = "Введите сумму пополнения баланса %s:\n";
    private static final String paymentAmount = "Введите сумму оплаты:";

    public static void main(String[] args) {

        double balance = 0;

        Scanner scanner = new Scanner(System.in);

        DebitCard debitCard = new DebitCard(balance);
        CreditCard creditCard = new CreditCard(balance);
        CreditCardWithCashback creditCardWithCashback = new CreditCardWithCashback(balance);
        DebitCardWithInterest debitCardWithInterest = new DebitCardWithInterest(balance);
        DebitCardWithBonus debitCardWithBonus = new DebitCardWithBonus(balance);
//        CreditCardBonus creditCardBonus = new CreditCardBonus(balance);
//        DebitCardCashBack debitCardCashBack = new DebitCardCashBack(balance);
//        CreditCardInterest creditCardInterest = new CreditCardInterest(balance);

        do {
            getMenu();
            int command = nextInt(scanner);
            switch (command) {
                case 1:
                    System.out.printf(replenishment, "Дебетовой карты");
                    debitCard.deposit(nextDouble(scanner));
                    pause();
                    break;
                case 2:
                    debitCard.getAllBalanceInfo();
                    pause();
                    break;
                case 3:
                    System.out.println(paymentAmount);
                    debitCard.pay(nextDouble(scanner));
                    pause();
                    break;
                case 4:
                    System.out.printf(replenishment, "Кредитной карты");
                    creditCard.deposit(nextDouble(scanner));
                    pause();
                    break;
                case 5:
                    creditCard.getAllBalanceInfo();
                    pause();
                    break;
                case 6:
                    System.out.println(paymentAmount);
                    creditCard.pay(nextDouble(scanner));
                    pause();
                    break;
                case 7:
                    System.out.printf(replenishment, "Кредитной карты с кешбэком");
                    creditCardWithCashback.deposit(nextDouble(scanner));
                    pause();
                    break;
                case 8:
                    creditCardWithCashback.getAllBalanceInfo();
                    pause();
                    break;
                case 9:
                    System.out.println(paymentAmount);
                    creditCardWithCashback.pay(nextDouble(scanner));
                    pause();
                    break;
                case 10:
                    System.out.printf(replenishment, "Дебетовой накопительной карты");
                    debitCardWithInterest.deposit(nextDouble(scanner));
                    pause();
                    break;
                case 11:
                    debitCardWithInterest.getAllBalanceInfo();
                    pause();
                    break;
                case 12:
                    System.out.println(paymentAmount);
                    debitCardWithInterest.pay(nextDouble(scanner));
                    pause();
                    break;
                case 13:
                    System.out.printf(replenishment, "Дебетовой бонусной карты");
                    debitCardWithBonus.earnBonusPoints(nextDouble(scanner));
                    pause();
                    break;
                case 14:
                    debitCardWithBonus.getAllBalanceInfo();
                    pause();
                    break;
                case 15:
                    System.out.println(paymentAmount);
                    debitCardWithBonus.pay(nextDouble(scanner));
                    pause();
                    break;

                case 0:
                    System.out.println("Выход");
                    return;
                default:
            }
        }
        while (true);


    }

    private static void getMenu() {
        System.out.println("\nВыберите действие: ");

        System.out.println("[1] - Пополнить дебетовую карту");
        System.out.println("[2] - Получить информацию о доступных средствах дебетовой карты");
        System.out.println("[3] - Оплатить дебетовой картой");

        System.out.println("4 - Пополнить кредитную карту");
        System.out.println("5 - Получить информацию о доступных средствах кредитной карты");
        System.out.println("6 - Оплатить кредитной картой");

        System.out.println("7 - Пополнить кредитную карту Кешбэк 5%");
        System.out.println("8 - Получить информацию о доступных средствах кредитной карты Кешбэк 5%");
        System.out.println("9 - Оплатить кредитную картой Кешбэк 5%");

        System.out.println("10 - Пополнить дебетовую накопительную карту 0.005%");
        System.out.println("11 - Получить информацию о доступных средствах дебетовой накопительной карты 0.005%");
        System.out.println("12 - Оплатить дебетовой накопительной картой  0.005%");

        System.out.println("13 - Пополнить дебетовую бонусную карту - Бонус 1%");
        System.out.println("14 - Получить информацию о доступных средствах дебетовой бонусной карты - Бонус 1%");
        System.out.println("15 - Оплатить дебетовой бонусной картой - Бонус 1%");

        System.out.println("0 - Выход");
        System.out.println();
    }

    private static int nextInt(Scanner scanner) {
        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        }
        System.out.printf("Ошибка ввода данных: %s, введите число от 0 до 15", scanner.nextLine());
        return -1;
    }

    private static double nextDouble(Scanner scanner) {
        if (scanner.hasNextDouble()) {
            return scanner.nextDouble();
        }
        System.out.printf("Ошибка ввода данных: %s, введите число от 0 до 15", scanner.nextLine());
        return -1;
    }

    private static void pause() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
