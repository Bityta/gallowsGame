package game.mainFunction.check;

import java.util.ArrayList;

public class Check {
    public static boolean validSymbol(String yourLetter) {

        if (yourLetter.length() != 1) return false;

        char letter = Character.toLowerCase(yourLetter.charAt(0));

        return letter >= 'a' && letter <= 'z';
    }

    public static boolean inLetterUsed(char letter, ArrayList<Character> letterUsed) {


        for (char i : letterUsed) {

            if (i == letter) return false;

        }

        return true;
    }

    public static boolean isGameOver(int numberOfMisses) {
        return !numberOfError(numberOfMisses);
    }

    private static boolean numberOfError(int numberOfMisses) {
        return numberOfMisses <= 11;
    }

    private static boolean remainLetter(char[] word) {

        for (char i : word) {
            if (i == '*') return true;
        }
        return false;
    }

    public static boolean isVictory(char[] word) {
        return !remainLetter(word);
    }
}
