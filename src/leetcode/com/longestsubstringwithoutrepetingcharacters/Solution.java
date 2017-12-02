package leetcode.com.longestsubstringwithoutrepetingcharacters;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public static void main(String args[]) {
		String s = "ababcd";
		int lengthOfLongestSubstring = new Solution().lengthOfLongestSubstring(s);
		System.out.println(lengthOfLongestSubstring);
	}

	public int lengthOfLongestSubstring(String string) {
		int numberOfChars = string.length();
		Set<Character> setControlString = new HashSet<Character>();
		int lengthOfLongest = 0, indexOfInitial = 0, indexOfEnd = 0;
		while (indexOfInitial < numberOfChars && indexOfEnd < numberOfChars) {
			if (!setControlString.contains(string.charAt(indexOfEnd))) {
				setControlString.add(string.charAt(indexOfEnd++));
				lengthOfLongest = Math.max(lengthOfLongest, indexOfEnd - indexOfInitial);
			} else
				setControlString.remove(string.charAt(indexOfInitial++));
		}
		return lengthOfLongest;
	}
}
