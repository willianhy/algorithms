package hackerrank.com.equalizethearray;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

//problem get from https://www.hackerrank.com/challenges/equality-in-a-array
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt();
        Map<Integer, Integer> integerOccurrence = new HashMap<Integer, Integer>();
        
        for(int c_i=0; c_i < n; c_i++){
        	int nextInt = in.nextInt();
			integerOccurrence.put(nextInt, integerOccurrence.get(nextInt) == null ? 1 : integerOccurrence.get(nextInt) + 1);
        }
        
        Integer highestKeyValue = 0;
        for (Entry<Integer, Integer> mapItem : integerOccurrence.entrySet()) {
			if (highestKeyValue ==0)
				highestKeyValue = mapItem.getKey();
			else if (mapItem.getValue() > integerOccurrence.get(highestKeyValue))
				highestKeyValue = mapItem.getKey();
		}
        
        System.out.println(n - integerOccurrence.get(highestKeyValue));

    }
}
