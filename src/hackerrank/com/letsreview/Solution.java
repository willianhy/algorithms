package hackerrank.com.letsreview;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfStrings = scan.nextInt();
        scan.nextLine();
        
        List<String> strings = new ArrayList<String>();
        for(int i = 0; i <= numberOfStrings - 1; i++){
            strings.add(scan.nextLine());
        }
        
        
        for(int i = 0; i <= numberOfStrings - 1; i++){
            String even = "";
            String odd = "";
            for(int j = 0; j <= strings.get(i).length() - 1; j++){
                if ((j % 2) == 1)
                    even += String.valueOf(strings.get(i).charAt(j));
                else
                    odd += String.valueOf(strings.get(i).charAt(j));
            }
            
            System.out.println(odd + " " + even);
        }
    }
}