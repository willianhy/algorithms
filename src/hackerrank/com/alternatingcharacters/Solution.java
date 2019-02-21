package hackerrank.com.alternatingcharacters;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
    	
    	char lastChar = 'X';    	
    	int deletions = 0;
    	for (int i = 0; i < s.length(); i++) {
    		if (lastChar == s.charAt(i))
    			deletions++;
    		lastChar = s.charAt(i);
		}
    	
    	return deletions;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);

            System.out.println(result);
        }
        scanner.close();
    }
}
