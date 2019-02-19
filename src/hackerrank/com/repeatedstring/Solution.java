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
    	
    	long division =  n/s.length();
    	int rest = (int) (n % s.length());
    	int countRest = 0;
    	for(int j = 0; j < rest; j++)
    		if (s.charAt(j) == 'a')
    			countRest++; 
    	
    	return division*count + countRest;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        String s = scanner.nextLine();
//
//        long n = scanner.nextLong();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//        long result = repeatedString(s, n);
//
//        System.out.println(String.valueOf(result));
//        scanner.close();
    	
    	System.out.println(repeatedString("a", 1000000000000L));
    }
}