// https://leetcode.com/problems/longest-nice-subarray/?envType=daily-question&envId=2025-03-18

class Solution {
    public int longestNiceSubarray(int[] nums) {
        int maxLen = 0; 
        int currAND = 0; 
        int left = 0; 

        for (int right = 0; right < nums.length; right++) {
           
            while ((currAND & nums[right]) != 0) {
                currAND ^= nums[left]; 
                                left++;
            }
            
            currAND |= nums[right];
            
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}
