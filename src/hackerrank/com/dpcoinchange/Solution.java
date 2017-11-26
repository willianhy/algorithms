package hackerrank.com.dpcoinchange;

import java.util.Scanner;

public class Solution {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
    	
        Scanner in = new Scanner(System.in);
        int value = in.nextInt();
        int numberOfCoins = in.nextInt();
        int coins[] = new int[numberOfCoins];
        for(int coins_i=0; coins_i < numberOfCoins; coins[coins_i++] = in.nextInt());
    	System.out.println(calc(value, coins));
    }
    
    public static long calc(int money, int[] coins) {
    	
//    	long[] DP = new long[money + 1]; // O(N) space.
//    	DP[0] = (long) 1; 	// n == 0 case.
//    	for(int coin : coins) {
//    		for(int j = coin; j < DP.length; j++) {
//    			// The only tricky step.
//    			DP[j] += DP[j - coin];
//    		}
//    	}       
//    	return DP[money];
       
        if (money == 0) return 1;
        if (coins.length == 0) return 0;
        
        long[] numberOfCoins = new long[money+1];
        numberOfCoins[0] = 1;       
        
        for (int coin : coins) 
            for (int i = 0; i < numberOfCoins.length-coin; i++) 
                numberOfCoins[i+coin] += numberOfCoins[i];
       
        return numberOfCoins[money];
    }
}
