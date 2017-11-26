package yassunaka.com.fibo.with.memo;

import java.util.HashMap;

public class Solution {
	public static void main(String args[]) {
		long number = 50;
		long startTime = System.currentTimeMillis();
		HashMap<Long, Long> memo = new HashMap<Long, Long>();
		System.out.println("fibo of " + number + " with memo " + fibo(number, memo));
		timeInMiliSeconds(startTime);
		
		startTime = System.currentTimeMillis();
		System.out.println("fibo of " + number + " without memo "+ fibo(number));
		timeInMiliSeconds(startTime);
	}

	private static void timeInMiliSeconds(long startTime) {
		System.out.println("Time in miliseconds: "+ (System.currentTimeMillis() - startTime));
	}
	
	private static Long fibo(Long number, HashMap<Long, Long> memo){
		if (number == 0)
			return (long) 0;
		if (number == 1)
			return (long) 1;
		if (!memo.containsKey(number))
			memo.put(number, fibo(number - 1, memo) + fibo(number - 2, memo));
			
		return memo.get(number);
	}
	
	private static Long fibo(Long number){
		if (number == 0)
			return (long) 0;
		if (number == 1)
			return (long) 1;
		return fibo(number - 1) + fibo(number - 2);
	}
}
