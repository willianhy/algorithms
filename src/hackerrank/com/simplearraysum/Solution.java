package hackerrank.com.simplearraysum;
import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        
        int[] numbers = new int[size];
        int sum = 0;
        for(int i = 0; i < size; numbers[i++] = scan.nextInt());
        for(int i = 0; i < size - 1; i++)
            sum += numbers[i];
        System.out.println(sum);
    }
}