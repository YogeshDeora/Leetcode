// https://leetcode.com/problems/partition-equal-subset-sum/?envType=daily-question&envId=2025-04-07

import java.util.Arrays;

class Solution {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) return false;
        
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;  
        
        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] || dp[j - num];
            }
        }
        
        return dp[target];
    }
}


