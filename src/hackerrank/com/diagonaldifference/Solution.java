package hackerrank.com.diagonaldifference;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rows = scan.nextInt();
        int firstDiagonalSum = 0, secondDiagonalSum = 0;
        
        int[][] matrix = new int[rows][rows];
        for(int i = 0; i < rows; i++)
            for(int j = 0; j < rows; j++){
                if (j == i)
                    firstDiagonalSum += scan.nextInt();
                if (j == (rows - i + 1))
                    secondDiagonalSum += scan.nextInt();
            }
               
        System.out.println((firstDiagonalSum + secondDiagonalSum));
        
    }
}