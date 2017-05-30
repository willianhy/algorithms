package hackerrank.com.nestedlogic;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] actually = new int[3];
        int[] expected = new int[3];
        
        for(int i = 0; i < 3; actually[i++] = scan.nextInt());
        for(int j = 0; j < 3; expected[j++] = scan.nextInt());
        
        if ((actually[2] < expected[2]) || 
        	(actually[2] == expected[2] && actually[1] < expected[1]) || 
        	(actually[2] == expected[2] && actually[1] == expected[1] && actually[0] <= expected[0]))
            System.out.print("0");
        else if (actually[1] == expected[1] && actually[2] == expected[2])
        	System.out.print((actually[0] - expected[0]) * 15);
        else if (actually[2] == expected[2] && actually[1] > expected[1])
        	System.out.println((actually[1] - expected[1]) * 500);
        else if (actually[2] > expected[2])
        	System.out.println("10000");
    }
}


