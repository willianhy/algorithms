package hackerrank.com.timeinwords;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int hour = in.nextInt();
        int minutes = in.nextInt();
        
        Map<Integer, String> intToWords = new HashMap<Integer, String>();
        intToWords.put(00, "o' clock");
        intToWords.put(1, "one");
        intToWords.put(2, "two");
        intToWords.put(3, "three");
        intToWords.put(4, "four");
        intToWords.put(5, "five");
        intToWords.put(6, "six");
        intToWords.put(7, "seven");
        intToWords.put(8, "eigth");
        intToWords.put(9, "nine");
        intToWords.put(10, "ten");
        intToWords.put(11, "eleven");
        intToWords.put(12, "twelve");
        intToWords.put(13, "thirteen");
        intToWords.put(14, "fourteen");
        intToWords.put(15, "quarter");
        intToWords.put(16, "sixteen");
        intToWords.put(17, "seventeen");
        intToWords.put(18, "eighteen");
        intToWords.put(19, "nineteen");
        intToWords.put(20, "twenty one");
        intToWords.put(21, "twenty one");
        intToWords.put(22, "twenty two");
        intToWords.put(23, "twenty three");
        intToWords.put(24, "twenty four");
        intToWords.put(25, "twenty five");
        intToWords.put(26, "twenty six");
        intToWords.put(27, "twenty seven");
        intToWords.put(28, "twenty eight");
        intToWords.put(29, "twenty nine");
        intToWords.put(30, "half past");
        
        if (minutes == 0)
        	System.out.println(intToWords.get(hour) + " " + intToWords.get(minutes));
        else if (minutes == 1)
        	System.out.println(intToWords.get(minutes) + " minute past " + intToWords.get(hour));
        else if (minutes == 15)
            System.out.println(intToWords.get(minutes) + " past " + intToWords.get(hour));
        else if (minutes > 1 && minutes < 30)
        	System.out.println(intToWords.get(minutes) + " minutes past " + intToWords.get(hour));
        else if (minutes == 30)
        	System.out.println(intToWords.get(minutes) +  " " + intToWords.get(hour));
        else if (minutes == 45)
        	System.out.println("quarter to " + intToWords.get(hour + 1 == 13 ? 1 : hour + 1));
        else
        	System.out.println(intToWords.get(60 - minutes) + " minutes to " + intToWords.get(hour + 1 == 13 ? 1 : hour + 1));
    }
}