package adventofcode;

public class Solution {

    public static void main(String[] args){
        int[] houses = new int[10000000];
        int counter = 0;
        for(int i = 1; i < houses.length; i++){
            for(int j = i; j < houses.length; j += i){
                if(counter < 50){
                    houses[j] += i * 11;
                    counter++;
                }
                else{
                    counter = 0;
                    break;
                }
            }
        }

        for(int i = 0; i < houses.length; i++){
            if(houses[i] >= 36000000){
                System.out.println("The house number is " + i);
                break;
            }
        }
    }
}