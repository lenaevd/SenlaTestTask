package first;

public class HangmanCondition {
    private static final String[] conditions = {

            " |---|\n" +
                    " О   |\n" +
                    "/|\\  |\n" +
                    "/ \\  |\n" +
                    "     |\n" +
                    "======\n",

            " |---|\n" +
                    " О   |\n" +
                    "/|\\  |\n" +
                    "/    |\n" +
                    "     |\n" +
                    "======\n",

            " |---|\n" +
                    " О   |\n" +
                    "/|\\  |\n" +
                    "     |\n" +
                    "     |\n" +
                    "======\n",

            " |---|\n" +
                    " О   |\n" +
                    "/|   |\n" +
                    "     |\n" +
                    "     |\n" +
                    "======\n",

            " |---|\n" +
                    " О   |\n" +
                    " |   |\n" +
                    "     |\n" +
                    "     |\n" +
                    "======\n",

            " |---|\n" +
                    " О   |\n" +
                    "     |\n" +
                    "     |\n" +
                    "     |\n" +
                    "======\n",

            " |---|\n" +
                    "     |\n" +
                    "     |\n" +
                    "     |\n" +
                    "     |\n" +
                    "======\n",
    };

    public static String getHangmanCondition(int attempts) {
        return conditions[attempts];
    }

}
