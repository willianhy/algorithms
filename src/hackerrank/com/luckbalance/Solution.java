package hackerrank.com.luckbalance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
    	
    	
    	List<Integer> important = new ArrayList<Integer>();
    	List<Integer> unimportant = new ArrayList<Integer>();
    	
    	for (int[] is : contests) 
			if (is[1] == 0)
				unimportant.add(is[0]);
			else
				important.add(is[0]);
		    	
    	Collections.sort(important, Collections.reverseOrder());
    	Collections.sort(unimportant, Collections.reverseOrder());
    	
    	int i = 0;
    	int luckAmount = 0;
    	for (Integer im : important) {
    		if (i < k)
    			luckAmount += im;
			else
				luckAmount -= im;			
			i++;
		}
    	
    	Iterator<Integer> iterator = important.iterator();
		while(iterator.hasNext()) {
			if (i < k)
				luckAmount += iterator.next();
			else
				luckAmount -= iterator.next();
			
			i++;
		}
    	
		Iterator<Integer> iterator2 = unimportant.iterator();
		while(iterator2.hasNext()) {
			luckAmount += iterator2.next();
		}
		

    	return luckAmount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);
        System.out.println(result);
        scanner.close();
    }
}
