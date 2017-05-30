package hackerrank.com.greedyflorist;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numberOfFlowers = scan.nextInt();
        int numberOfPeople = scan.nextInt();
        
        List<Integer> flowersPrice = new ArrayList<Integer>();
        for(int index = 0; index < numberOfFlowers; index++)
            flowersPrice.add(scan.nextInt());
        
        Collections.sort(flowersPrice);
        
        int sum = 0;
        int count = 0;
        for (int i = 1; i <= (numberOfFlowers / numberOfPeople) + (numberOfFlowers % numberOfPeople); i++) {
			for(int j = 0; j < numberOfPeople; j++){
				if (count >= numberOfFlowers)
					break;
				
				sum += i*moreExpensive(flowersPrice);
				count++;
			}
		}     
        
        System.out.println(sum);
    }
    
	private static Integer moreExpensive(List<Integer> costs){
    	return costs.remove(costs.size() - 1);
    }
}