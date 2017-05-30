package hackerrank.com.almostsorted;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int sizeOfArray = scan.nextInt();

		int[] numbers = new int[sizeOfArray];
		for (int index = 0; index < sizeOfArray; numbers[index++] = scan.nextInt());
		
		if (isOrdered(numbers)){
			System.out.println("yes");
			return;
		}
		
		int i, j;
		for(i = 0; i < sizeOfArray - 1 && numbers[i] < numbers[i + 1]; i++);
		for(j = sizeOfArray - 1; j > 0&& numbers[j] > numbers[j - 1]; j--);
			
		swap(numbers, i, j);
		if (isOrdered(numbers)){
			System.out.println("yes\nswap " + (i+1) + " " + (j+1));
			return;
		}
		
		int k = i + 1, l = j - 1;
		while(k < l) 
			swap(numbers, k++, l--);
		if (isOrdered(numbers)){
			System.out.println("yes\nreverse " + (i+1) + " " + (j+1));
			return;
		}
		
		System.out.println("no");
	}
	
	private static boolean isOrdered(int[] arrayToVerify){
		for(int index = 0; index < arrayToVerify.length - 1; index++)
			if (arrayToVerify[index] > arrayToVerify[index + 1])
				return false;
		return true;
	}
	
	private static void swap(int[] array, int begin, int end){
		int transitory = array[begin];
		array[begin] = array[end];
		array[end] = transitory;
	}
}
