package game.mainFunction;

import game.mainFunction.check.Check;
import game.mainFunction.print.Print;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import static DataBase.DatabaseValues.*;
import static Utils.Utils.*;

public class MainFunctionGame {

    protected static final int DIVIDING_LINE = 70;
    public static final String GREETING = "=".repeat(DIVIDING_LINE) + "\nПриветствую дорогой Игрок\n" +
            "Все просто игра назывется Виселица\n" +
            "Я загадываю слово, а ты отгадываешь его, вводя буквы в терминал\n" +
            "Полные правила - ....\n" +
            "Удачной игры" + "\n" + "=".repeat(DIVIDING_LINE);

    public static String selectRandomWordFromDB() {

        Connection conn = null;
        int count = 0;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT id FROM word");

            while (resultSet.next()) count++;
            resultSet = statement.executeQuery("SELECT * FROM word");
            resultSet.next();

            int num = (int) (Math.random() * (count)) + 1;

            for (int i = 0; i < count; i++) {
                if (resultSet.getInt("id") == num) return resultSet.getString("word");

                resultSet.next();
            }

        } catch (Exception e) {
            System.out.println("Error connection");
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


        return "Error";
    }

    public static char inputLetter(char[] word, ArrayList<Character> letterUsed) {

        Print.guessedWord(word);
        Print.letterUsed(letterUsed);

        Scanner scanner = new Scanner(System.in);

        System.out.print("\n\nВведите Ваше букву: ");

        String Symbol = scanner.next();
        System.out.println("\n" + "=".repeat(DIVIDING_LINE));

        while (!Check.validSymbol(Symbol)) {
            System.out.println(RED + "!!! Error: Кажется, Вы ввели недопустимую букву или\\и лишние символы !!! \n" + RESET);
            Symbol = Character.toString(inputLetter(word, letterUsed));
        }

        return Character.toLowerCase(Symbol.charAt(0));


    }

    public static char[] openLetter(char[] word, String guessedWord, char letter) {


        for (int i = 0; i < guessedWord.length(); i++) {
            if (guessedWord.charAt(i) == letter) word[i] = letter;
        }

        return word;
    }

    public static void gameOver(boolean isGameOver, char[] word, String guessedWord, ArrayList<Character> letterUsed) {
        if (isGameOver) {
            System.out.println("ГГ, вы проиграли\n");
            Print.stateWord(guessedWord);
            Print.guessedWord(word);


        } else {
            Print.guessedWord(word);
            Print.letterUsed(letterUsed);
            System.out.println(GREEN + "\n\nПоздравляю игра окончена!! \nВы победили!!!!! \n" + RESET);

        }
    }




}
