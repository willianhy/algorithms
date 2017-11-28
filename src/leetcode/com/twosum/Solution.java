package leetcode.com.twosum;

public class Solution {
	public static void main(String args[]) {
		int[] nums = new int[]{2, 7, 11, 15};
		int target = 9;
		int[] twoSum = new Solution().twoSum(nums, target);
		System.out.println(twoSum);
	}
	
    public int[] twoSum(int[] nums, int target) {
    	for(int i = 0; i < nums.length - 1; i++)
    		for(int j = i + 1; j < nums.length; j++)
    			if (nums[i] + nums[j] == target)
    				return new int[]{i, j};
    	
    	throw new RuntimeException("No solution");
    }
}
