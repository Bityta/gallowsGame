package game;

import Utils.Utils;
import game.mainFunction.check.Check;
import game.mainFunction.print.Print;
import java.util.ArrayList;

import static Utils.Utils.*;
import static game.mainFunction.MainFunctionGame.*;

public class Game {
    public static void startGame() {

        boolean isGameOver = false;
        boolean isVictory = false;
        int numberOfMisses = 0;
        ArrayList<Character> letterUsed = new ArrayList<>();
        String guessedWord = selectRandomWordFromDB();
        char[] word = Utils.repeatChar('*', guessedWord.length());


        System.out.println(GREETING);


        while (!isGameOver && !isVictory) {

            char letter = inputLetter(word, letterUsed);

            if (!Check.inLetterUsed(letter, letterUsed)) {
                System.out.println(RED + "!!! Error: Кажется, Вы уже вводили эту букву !!! \n" + RESET);
                Print.gallows(word, guessedWord, letter, numberOfMisses-1);
                continue;
            } else letterUsed.add(letter);


            numberOfMisses = Print.gallows(word, guessedWord, letter, numberOfMisses);

            isGameOver = Check.isGameOver(numberOfMisses);
            isVictory = Check.isVictory(word);

        }


        gameOver(isGameOver, word, guessedWord, letterUsed);

    }
}
