package adventofcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    static int[] player = new int[4];
    static int[] boss = new int[3];

    static int[][] weapons = {{8  , 4, 0},
                              {10 , 5, 0},
                              {25 , 6, 0},
                              {40 , 7, 0},
                              {74 , 8, 0}};

    static int[][] armor =   {{13 , 0, 1},
                              {31 , 0, 2},
                              {53 , 0, 3},
                              {75 , 0, 4},
                              {102, 0, 5}};

    static int[][] rings =   {{25 , 1, 0},
                              {50 , 2, 0},
                              {100, 3, 0},
                              {20 , 0, 1},
                              {40 , 0, 2},
                              {80 , 0, 3}};

    static ArrayList<Integer[]> items = buyItems();

    public static ArrayList<Integer[]> buyItems(){
        ArrayList<Integer[]> output = new ArrayList<>();
        for(int w = 0; w < weapons.length; w++){
            for(int a = -1; a < armor.length; a++){
                for(int r1 = -1; r1 < rings.length; r1++){
                    for(int r2 = -1; r2 < rings.length; r2++){
                        if(r1 != r2 && r1 != -1){
                            Integer[] add = {w,a,r1,r2};
                            output.add(add);
                        }
                    }
                }
            }
        }
        return output;
    }

    public static int[] assignStats(Integer[] items){
        int[] output = new int[4];
        output[0] = 100;

        output[1] = weapons[items[0]][1];
        output[3] = weapons[items[0]][0];

        output[2]  = items[1] == -1 ? 0 : armor[items[1]][2];
        output[3] += items[1] == -1 ? 0 : armor[items[1]][0];

        if(items[2] != -1){
            output[1] += rings[items[2]][1];
            output[2] += rings[items[2]][2];
            output[3] += rings[items[2]][0];
        }
        if(items[3] != -1){
            output[1] += rings[items[3]][1];
            output[2] += rings[items[3]][2];
            output[3] += rings[items[3]][0];
        }

        return output;
    }

    public static boolean victory(){
        int health = boss[0];
        while(true){
            boss[0] -= player[1] - boss[2];
            if(boss[0] < 1){
                boss[0] = health;
                return true;
            }
            player[0] -= boss[1] - player[2];
            if(player[0] < 1){
                boss[0] = health;
                return false;
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("input21.txt"));

        int cost = 0;

        for(int i = 0; i < 3; i++){
            boss[i] = Integer.parseInt(s.nextLine().split(" ")[i == 0 ? 2 : 1]);
        }

        for(Integer[] i : items){
            player = assignStats(i);
            if(!victory()){
                if(player[3] > cost){
                    cost = player[3];
                }
            }
        }

        System.out.println("The highest cost is " + cost + ".");
    }
}