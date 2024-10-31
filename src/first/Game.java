package first;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Game {
    private int attempts; // количество жизней
    private String secretWord; //загаданное слово
    private StringBuilder hiddenWord; // слово которое выводится с пропусками
    private Set<Character> rightLetters; // все правильные буквы
    private Set<Character> guessedLetters; // все буквы, введенные пользователем
    String hangman;

    public Game(String secret) {
        this.attempts = 6;
        StringBuilder hidden = new StringBuilder();
        Set<Character> letters = new HashSet<>();
        for (int i = 0; i < secret.length(); i++) {
            letters.add(secret.charAt(i));
            hidden.append("_");
        }
        this.secretWord = secret;
        this.hiddenWord = hidden;
        this.rightLetters = letters;
        this.guessedLetters = new HashSet<>();
        this.hangman = HangmanCondition.getHangmanCondition(attempts);
        System.out.println("Игра началась");
    }

    public void start() {

        while (!isGameOver()) {
            System.out.println("Количество жизней: " + attempts);
            System.out.println("Загаданное слово: " + hiddenWord);
            System.out.println(hangman);

            System.out.println("Введите строчную букву");
            Scanner scan = new Scanner(System.in);
            char letter = scan.nextLine().charAt(0);

            if (guessedLetters.contains(letter)) {
                System.out.println("Эта буква уже была введена");
            } else if (isLetterRight(letter)) {
                System.out.println("Вы угадали!");
                guessedLetters.add(letter);
                updateHiddenWord(letter);
            } else {
                System.out.println("Неправильная буква, вы потеряли жизнь");
                guessedLetters.add(letter);
                attempts--;
                hangman = HangmanCondition.getHangmanCondition(attempts);
            }
        }
    }

    public boolean isGameOver() {
        if (attempts == 0) {
            System.out.println("Жизни закончились. Вы проиграли :(");
            System.out.println(hangman);
            return true;
        } else if (secretWord.contentEquals(hiddenWord)) {
            System.out.println("Угаданное слово: " + hiddenWord + ". Вы выиграли :)");
            return true;
        } else {
            return false;
        }
    }

    public boolean isLetterRight(Character letter) {
        return rightLetters.contains(letter);
    }

    public void updateHiddenWord(char letter) {
        for (int i = 0; i < secretWord.length(); i++) {
            if (secretWord.charAt(i) == letter) {
                hiddenWord.setCharAt(i, letter);
            }
        }
    }

}
