package hackerrank.com.icescreamparlor;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfTrips = scan.nextInt();
        
        for(int trip = 0; trip < numberOfTrips; trip++)
            iceScreamParlor(scan);    
    }
    
    private static void iceScreamParlor(Scanner scan){
        int money = scan.nextInt();
        int numberOfFlavours = scan.nextInt();
        int[] flavoursCost = new int[numberOfFlavours];
        for(int index = 0; index < numberOfFlavours; flavoursCost[index++] = scan.nextInt());
        
        for(int i = 0; i < numberOfFlavours; i++)
            for(int j = i + 1; j < numberOfFlavours; j++)
               if (flavoursCost[i] + flavoursCost[j] == money){
                    System.out.println((i + 1) + " " + (j + 1));
                    return;
                }
    }
}