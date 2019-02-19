package hackerrank.com.sockmerchant;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {

    	HashMap<Integer, Integer> socks = new HashMap<Integer, Integer>();
    	
    	for (int i : ar) 
			socks.put(i, socks.get(i) == null ? 1 : socks.get(i) + 1);
		
    	int pairs = 0;
    	for (int i: socks.keySet()) 
    		pairs += socks.get(i)/2;
		    	
    	return pairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {       

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        System.out.println(String.valueOf(result));

        scanner.close();
    }
}