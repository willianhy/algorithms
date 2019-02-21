package hackerrank.com.twostrings;

import static java.util.Arrays.asList;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
    	
    	Set<Character> mySet1 = new HashSet<Character>(Arrays.asList(s1.chars().mapToObj(ch -> (char) ch).toArray(Character[]::new)));
    	Set<Character> mySet2 = new HashSet<Character>(Arrays.asList(s2.chars().mapToObj(ch -> (char) ch).toArray(Character[]::new)));
    	
    	for (Character charac : mySet1) 
			if (mySet2.contains(charac))
				return "YES";
    	
    	return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            System.out.println(result);
        }

        scanner.close();
    }
}
