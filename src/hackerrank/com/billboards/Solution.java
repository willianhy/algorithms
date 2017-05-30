package hackerrank.com.billboards;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        int n = scan.nextInt();
        int k = scan.nextInt();
        
        int[] billboards = new int[n];
        for(int i = 0; i < n; billboards[i++] = scan.nextInt());
        
        Map<Integer, Integer> attempts = new HashMap<Integer, Integer>();
        for(int a = 0; a <= k; a++)
        	for(int b = 0; b < n; b++){
        		//if ((b == a) || (b == a + 1 + k)) 
        		//	continue;
        		if (isValid(a, k, b))
        			continue;
        		attempts.put(a, (attempts.get(a) != null ? attempts.get(a) : 0) +  billboards[b]);
        	}
  
        int higher = 0;
        for (int key : attempts.keySet()) 
        	if (attempts.get(key) > higher)
        		higher = attempts.get(key);
        
        System.out.println(higher);
    }
    
    private static boolean isValid(int a, int k, int b){
    	if (a == b) return true;
    	if (a > b) return false;
    	return isValid(a + k + 1, k, b);
    }
}
