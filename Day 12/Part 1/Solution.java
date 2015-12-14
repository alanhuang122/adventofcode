package adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("input12.txt"));
        int output = 0;
        
        String input = s.nextLine();

        input = input.replaceAll("[\\[\\]\"{},:a-z]", " ");

        s = new Scanner(input);

        while(s.hasNext()){
            output += s.nextInt();
        }

        System.out.println("The sum is " + output + ".");
    }
}