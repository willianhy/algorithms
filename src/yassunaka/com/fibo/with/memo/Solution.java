package yassunaka.com.fibo.with.memo;

import java.util.HashMap;

public class Solution {
	public static void main(String args[]) {
		int number = 45;
		long startTime = System.currentTimeMillis();
		HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();
		System.out.println("fibo with memo " + fibo(number, memo));
		timeInMiliSeconds(startTime);
		
		startTime = System.currentTimeMillis();
		System.out.println("fibo without memo "+ fibo(number));
		timeInMiliSeconds(startTime);
	}

	private static void timeInMiliSeconds(long startTime) {
		System.out.println("Time in miliseconds: "+ (System.currentTimeMillis() - startTime));
	}
	
	private static int fibo(int number, HashMap<Integer, Integer> memo){
		if (number == 0)
			return 0;
		if (number == 1)
			return 1;
		if (!memo.containsKey(number))
			memo.put(number, fibo(number - 1, memo) + fibo(number - 2, memo));
			
		return memo.get(number);
	}
	
	private static int fibo(int number){
		if (number == 0)
			return 0;
		if (number == 1)
			return 1;
		return fibo(number - 1) + fibo(number - 2);
	}
}
