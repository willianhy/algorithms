package hackerrank.com.binarynumbers;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String numberInBinary = binaryRepresentation(n);
        
        int maxFoundOut = 0;
        int currentCount = 0;
        char one = '1';
        for(char ch: numberInBinary.toCharArray()){
            if (ch  == one){
                currentCount++;
                
                if (currentCount > maxFoundOut)
                    maxFoundOut = currentCount;
            }
            else
            	currentCount = 0;
        }
        System.out.println(maxFoundOut);
    }
    
    private static String binaryRepresentation(Integer number){
        return Integer.toBinaryString(number);
    }
}