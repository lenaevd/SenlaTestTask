package first;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Hangman {

    public static void main(String[] args) {
        String[] wordsForHangman = {"разработка", "массив", "цикл", "данные", "информация", "коллекция", "алгоритм",
                "задание", "микросервис", "автоматизация", "интерфейс", "консоль", "ресурсы", "безопасность", "паттерн",
                "многопоточность", "сериализация", "пользователь", "клиент", "реализация"};
        List<String> words = Arrays.asList(wordsForHangman);
        Random random = new Random();
        first.Game game = new first.Game(words.get(random.nextInt(words.size())));
        game.start();
    }
}
