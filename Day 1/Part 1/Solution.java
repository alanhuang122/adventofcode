package adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution {
    
    public static int move(String s){
        int total = 0;
        char[] characters = s.toCharArray();
        for(char c : characters){
            if(c == '('){
                total++;
            }
            else{
                total--;    
            }
        }
        return total;
    }
 
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("C:\\Users\\Alan\\Downloads\\input1.txt"));
    
        System.out.println("Santa ends up at floor " + move(s.next()) + ".");
    }
}