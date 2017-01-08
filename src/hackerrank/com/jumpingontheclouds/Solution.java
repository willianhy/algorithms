package hackerrank.com.jumpingontheclouds;

import java.util.Scanner;

//problem get from https://www.hackerrank.com/challenges/jumping-on-the-clouds
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        
        int i = 0;
        int count = 0;
        while(i < n - 1){
           if (i + 2 <= n - 1 && c[i + 2] == 0)
               i = i + 2;
           else
               i++;
           count++; 
        }
        System.out.println(count);
    }
}
