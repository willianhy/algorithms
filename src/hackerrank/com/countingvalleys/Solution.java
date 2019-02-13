package hackerrank.com.countingvalleys;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
    	Stack<Character> stack = new Stack<Character>();
    	int valley = 0;
    	
    	for (int i = 0; i < n; i++) {
    		char charAt = s.charAt(i);
    		if (charAt == 'D' && stack.isEmpty()) 
    			valley++;
    		
    		if (stack.isEmpty())
    			stack.push(charAt);
    		else if (stack.peek() != charAt)
    			stack.pop();
    		else
    			stack.push(charAt);    		
		}    	
    	
    	return valley;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {        
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        System.out.println(String.valueOf(result));
        scanner.close();
    }
}