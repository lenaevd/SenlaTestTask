package second;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CurrencyConverter {

    private static boolean areCurrenciesOk;

    private static final double rubleToEuro = 0.0095;
    private static final double rubleToDollar = 0.0103;
    private static final double rubleToYuan = 0.0736;
    private static final double rubleToPound = 0.0079;

    private static final double euroToDollar = 1.0833;
    private static final double euroToYuan = 7.7554;
    private static final double euroToPound = 0.8336;

    private static final double dollarToYuan = 7.1588;
    private static final double dollarToPound = 0.7695;

    private static final double yuanToPound = 0.1075;

    public static void main(String[] args) {

        areCurrenciesOk = true;

        while (areCurrenciesOk) {

            System.out.println("Введите конвертируемую валюту: Рубль, Евро, Доллар, Юань, Фунт");
            Scanner scanner = new Scanner(System.in);
            String currencyFrom = scanner.nextLine();

            System.out.println("Введите сумму");
            double amount = 0;
            boolean isSumOk;
            try {
                amount = scanner.nextDouble();
                isSumOk = true;
            } catch (InputMismatchException e) {
                System.out.println("Сумма была введена неверно");
                isSumOk = false;
            }

            if (isSumOk) {
                System.out.println("Введите валюту, в которую хотите конвертировать:");
                String currencyTo = scanner.next();

                double sum = convert(currencyFrom, amount, currencyTo);

                if (areCurrenciesOk) {
                    System.out.println(amount + " " + currencyFrom + " = " + sum + " " + currencyTo);
                }
            }
            areCurrenciesOk = true;
        }
    }

    public static double convert(String from, double amount, String to) {
        switch (from) {
            case "Рубль":
                return convertFromRuble(amount, to);
            case "Евро":
                return convertFromEuro(amount, to);
            case "Доллар":
                return convertFromDollar(amount, to);
            case "Юань":
                return convertFromYuan(amount, to);
            case "Фунт":
                return convertFromPound(amount, to);
            default: {
                System.out.println("Валюта была введена неверно");
                areCurrenciesOk = false;
                break;
            }
        }
        return 0;
    }

    public static double convertFromRuble(double amount, String to) {
        switch (to) {
            case "Рубль":
                return amount;
            case "Евро":
                return amount * rubleToEuro;
            case "Доллар":
                return amount * rubleToDollar;
            case "Юань":
                return amount * rubleToYuan;
            case "Фунт":
                return amount * rubleToPound;
            default: {
                System.out.println("Валюта была введена неверно");
                areCurrenciesOk = false;
                break;
            }
        }
        return 0;
    }

    public static double convertFromEuro(double amount, String to) {
        switch (to) {
            case "Рубль":
                return amount / rubleToEuro;
            case "Евро":
                return amount;
            case "Доллар":
                return amount * euroToDollar;
            case "Юань":
                return amount * euroToYuan;
            case "Фунт":
                return amount * euroToPound;
            default: {
                System.out.println("Валюта была введена неверно");
                areCurrenciesOk = false;
                break;
            }
        }
        return 0;
    }

    public static double convertFromDollar(double amount, String to) {
        switch (to) {
            case "Рубль":
                return amount / rubleToDollar;
            case "Евро":
                return amount / euroToDollar;
            case "Доллар":
                return amount;
            case "Юань":
                return amount * dollarToYuan;
            case "Фунт":
                return amount * dollarToPound;
            default: {
                System.out.println("Валюта была введена неверно");
                areCurrenciesOk = false;
                break;
            }
        }
        return 0;
    }

    public static double convertFromYuan(double amount, String to) {
        switch (to) {
            case "Рубль":
                return amount / rubleToYuan;
            case "Евро":
                return amount / euroToYuan;
            case "Доллар":
                return amount / dollarToYuan;
            case "Юань":
                return amount;
            case "Фунт":
                return amount * yuanToPound;
            default: {
                System.out.println("Валюта была введена неверно");
                areCurrenciesOk = false;
                break;
            }
        }
        return 0;
    }

    public static double convertFromPound(double amount, String to) {
        switch (to) {
            case "Рубль":
                return amount / rubleToPound;
            case "Евро":
                return amount / euroToPound;
            case "Доллар":
                return amount / dollarToPound;
            case "Юань":
                return amount / yuanToPound;
            case "Фунт":
                return amount;
            default: {
                System.out.println("Валюта была введена неверно");
                areCurrenciesOk = false;
                break;
            }
        }
        return 0;
    }
}
