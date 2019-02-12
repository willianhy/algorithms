package hackerrank.com.twodarrayds;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
    	int maxValue = Integer.MIN_VALUE;
    	
    	for (int i = 0; i < arr.length - 2; i++) 
			for (int j = 0; j < arr[0].length - 2; j++) {				
				int currentSum = 0;
				currentSum += arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2];
				if (currentSum > maxValue)
		    		maxValue = currentSum; 
			}   	
    	
    	return maxValue;
    }    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {       

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        System.out.println(result);       

        scanner.close();
    }
}