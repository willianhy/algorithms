package hackerrank.com.makinganagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static int numberNeeded(String first, String second) {
		boolean[] removedFirst = new boolean[first.length()];
		boolean[] removedSecond = new boolean[second.length()];
		
		for(int i = 0; i < first.length(); i++)
			for(int j = 0; j < second.length(); j++)
				if (!removedFirst[i] && first.charAt(i) == second.charAt(j) && !removedSecond[j]){
					removedFirst[i] = true;
					removedSecond[j] = true;
					break;
				}
		
		int sumRemovedFirst = 0;
		for(int i = 0; i < first.length(); i++)
			if (removedFirst[i])
				sumRemovedFirst++;
		
		int sumRemovedSecond = 0;
		for(int j = 0; j < second.length(); j++)
			if (removedSecond[j])
				sumRemovedSecond++;
		
		return first.length() + second.length() - sumRemovedFirst - sumRemovedSecond;
    
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
        in.close();
    }
}


