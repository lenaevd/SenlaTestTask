package third;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import java.util.Collections;

public class PasswordGenerator {
    //в полях класса хранятся списки символов
    private final List<Character> upperCaseLetters;
    private final List<Character> lowerCaseLetters;
    private final List<Character> numbers;
    private final List<Character> specialSymbols;
    private final List<Character> allSymbols;

    public static void main(String[] args) {
        PasswordGenerator generator = new PasswordGenerator();

        int num = generator.getNumberOfCharacters();
        while (!(num >= 8 && num <= 12)) { // если введено неподходящее число, запрашиваем у пользователя новое
            num = generator.getNumberOfCharacters();
        }
        System.out.println("Cгенерирован пароль из " + num + " символов: " + generator.generatePassword(num));
    }

    public PasswordGenerator() {
        // заполняем поля класса в конструкторе
        List<Character> all = new ArrayList<>();

        List<Character> upper = new ArrayList<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            upper.add(c);
            all.add(c);
        }
        for (char c = 'А'; c <= 'Я'; c++) {
            upper.add(c);
            all.add(c);
        }

        List<Character> lower = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            lower.add(c);
            all.add(c);
        }
        for (char c = 'а'; c <= 'я'; c++) {
            lower.add(c);
            all.add(c);
        }

        List<Character> numbers = new ArrayList<>();
        for (char c = '0'; c <= '9'; c++) {
            numbers.add(c);
            all.add(c);
        }

        List<Character> specials = new ArrayList<>();
        char[] spec = "`~!@\"#№$;%^&?*()-_+=|/\\.,{[]}<>".toCharArray();
        for (char c : spec) {
            specials.add(c);
            all.add(c);
        }
        this.upperCaseLetters = upper;
        this.lowerCaseLetters = lower;
        this.numbers = numbers;
        this.specialSymbols = specials;
        this.allSymbols = all;
    }

    private int getNumberOfCharacters() {
        int numberOfCharacters;
        System.out.println("Введите число символов в пароле (от 8 до 12)");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                numberOfCharacters = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {  //на случай, если введено не число
                System.out.println("Введите число символов в пароле (от 8 до 12)");
            }
        }
        return numberOfCharacters;
    }

    private String generatePassword(int number) {
        // символы, из которых будет создан пароль
        List<Character> symbolsForPassword = new ArrayList<>();

        Random rand = new Random();

        //добавляю по одному символу каждого вида, чтобы гарантировать их наличие в пароле
        symbolsForPassword.add(upperCaseLetters.get(rand.nextInt(upperCaseLetters.size())));
        symbolsForPassword.add(lowerCaseLetters.get(rand.nextInt(lowerCaseLetters.size())));
        symbolsForPassword.add(numbers.get(rand.nextInt(numbers.size())));
        symbolsForPassword.add(specialSymbols.get(rand.nextInt(specialSymbols.size())));

        //дополняю оставшиеся символы
        for (int i = 1; i <= number - 4; i++) {
            symbolsForPassword.add(allSymbols.get(rand.nextInt(allSymbols.size())));
        }

        // перемешиваю символы
        Collections.shuffle(symbolsForPassword);

        StringBuilder str = new StringBuilder();
        for (char c : symbolsForPassword) {
            str.append(c);
        }
        return str.toString();
    }
}
