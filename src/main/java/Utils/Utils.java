package Utils;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Utils {

    public static char[] repeatChar(char letter, int count) {

        char[] ans = new char[count];

        for (int i = 0; i < count; i++) {

            ans[i] = letter;
        }

        return ans;
    }

    public static char[] copyArray(char[] word) {

        char[] ans = new char[word.length];

        for (int i = 0; i < word.length; i++) ans[i] = word[i];

        return ans;
    }

    public static ArrayList<String> readFile(){


        ArrayList<String> word = new ArrayList<>();

        File file = new File("src\\main\\resources\\word.txt");

        try{
            Scanner scanner = new Scanner(file);

            while(scanner.hasNextLine()){
                word.add(scanner.nextLine());
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        return word;
    }


    public static final String RED = "\033[0;31m";     // RED
    public static final String RESET = "\033[0m";  // Text Reset

    public static final String GREEN = "\033[0;32m";   // GREEN



}


