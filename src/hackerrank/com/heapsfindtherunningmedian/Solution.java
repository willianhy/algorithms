package hackerrank.com.heapsfindtherunningmedian;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
    public static void main(String[] args) {
        @SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<Integer, Double> map = new HashMap<Integer, Double>();
        List<Integer> newList = new ArrayList<Integer>();
        for (int i = 0; i < n; i++){
    		int valueTyped = in.nextInt();
    		int pos = Collections.binarySearch(newList, valueTyped);
    	    if (pos < 0) pos = Math.abs(pos)-1;
    	    newList.add(pos, valueTyped);
    	    
    		map.put(i, medium(newList));
        }
        for (int i = 0; i < n; i++) 
			System.out.println(map.get(i));
		
    }
    
    public static double medium(List<Integer> input){
    	int size = input.size();
		int mid = size / 2;
		if ((size & 1) == 1)
    		return input.get(mid);
		
		return (input.get(mid - 1) + input.get(mid))/2.0;
    }
}
