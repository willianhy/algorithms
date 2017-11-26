package hackerrank.com.triescontacts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
    //TODO needs to improve... some tests arent passing... :( 
    //maybe implement tries with tree?
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int numberOfOperations = scan.nextInt();
		scan.nextLine();
		List<String> names = new ArrayList<String>();
		StringBuilder result = new StringBuilder();
		
		for (int i = 0; i < numberOfOperations; i++) {
			String[] split = scan.nextLine().split(" ");
			String command = split[0];
			String content = split[1];
			
			if (command.equals("add")){
				int pos = Collections.binarySearch(names, content);
				if (pos < 0) pos = Math.abs(pos) - 1;
				names.add(pos, content);
				
			}else if(command.equals("find")){
				boolean findSometime = false;
				int sum = 0;
				int pos = Collections.binarySearch(names, content);
				
				if (pos >= 0 || (pos < 0 && (pos = Math.abs(pos) - 1) < names.size())){
					for (; pos < names.size(); pos++){
						if (names.get(pos).startsWith(content)){
							sum++;
							findSometime = true;
						}
						else
							if (findSometime == true)
								break;
					}
				}
				
				if (result.length() > 0)
					result.append(System.getProperty("line.separator"));
				result.append(sum);
			}	
		}
		
		System.out.println(result.toString());
	}
}