package game.mainFunction.print;

import java.util.ArrayList;

import Utils.Utils;

import static game.mainFunction.MainFunctionGame.*;
import static gameStateFigure.Figure.STATE;

public class Print {
    public static void guessedWord(char[] word) {
        System.out.println("\n");

        Print.stateWord(word);

        System.out.println();
        for (int i = 0; i < word.length; i++) {


            System.out.print("_ ");
        }


    }

    public static void stateWord(char[] word) {
        for (char letter : word) System.out.print(letter + " ");
    }

    public static void stateWord(String guessedWord) {
        for (int i = 0; i < guessedWord.length(); i++) {
            System.out.print(guessedWord.charAt(i) + " ");
        }
    }

    public static void letterUsed(ArrayList<Character> letterUsed) {
        System.out.print("\n\nИспользуемые буквы: ");
        for (char i : letterUsed) {
            System.out.print(i + ", ");
        }

    }

    public static int gallows(char[] word, String guessedWord, char letter, int numberOfMisses) {

        boolean p = false;
        char[] temp = Utils.copyArray(word);

        for (int i = 0; i < guessedWord.length(); i++) {

            if (temp[i] != openLetter(word, guessedWord, letter)[i]) {
                p = true;
                break;
            }
        }

        if (!p)numberOfMisses++;


        System.out.println(STATE[numberOfMisses]);

        return numberOfMisses;
    }

}
