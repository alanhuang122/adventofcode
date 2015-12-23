package adventofcode;

public class Solution {

    static int[] houses = new int[3600000];

    public static void main(String[] args){
        int house = 0;
        for(int i = 1; i < 3600000; i++){
            for(int j = i; j < 3600000; j += i){
                houses[j] += i * 10;
            }
        }

        for(int i = 2; i < houses.length; i++){
            if(houses[i] >= 36000000){
                house = i;
                break;
            }
        }

        System.out.println("The house number is " + house);
    }
}