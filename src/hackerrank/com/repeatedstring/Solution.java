package hackerrank.com.repeatedstring;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
    	int count = 0;    	
    	int i = 0;
    	for (; i < s.length(); i++) 
			if (s.charAt(i % s.length()) == 'a')
				count++;
    	
    	if (i == n)
    		return count;
    	
    	int countRest = 0;
    	for(int j = 0; j < (int) (n % s.length()); j++)
    		if (s.charAt(j) == 'a')
    			countRest++; 
    	
    	return (n/s.length())*count + countRest;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        long result = repeatedString(s, n);

        System.out.println(String.valueOf(result));
        scanner.close();
    }
}