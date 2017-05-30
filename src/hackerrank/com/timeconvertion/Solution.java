package hackerrank.com.timeconvertion;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String time = in.next();
        
        String amOrPm = time.substring(time.length() - 2);
        
        if (amOrPm.equals("AM"))
            System.out.println(time.substring(0, 8));
        else{
            int hour = Integer.parseInt(time.substring(0, 2)) + 12;
            System.out.println(hour + time.substring(2, 8));
        }
    }
}