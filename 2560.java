// https://leetcode.com/problems/house-robber-iv/?envType=daily-question&envId=2025-03-15

class Solution {
    public int minCapability(int[] nums, int k) {
        // Perform binary search on capability
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        for (int num : nums) {
            left = Math.min(left, num);
            right = Math.max(num, right);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canRobWithCapability(nums, k, mid)) {
                right = mid; // Try lower capability
            } else {
                left = mid + 1; // Increase capability
            }
        }

        return left;
    }

    // Helper function to check feasibility
    private boolean canRobWithCapability(int[] nums, int k, int cap) {
        int robbed = 0;
        int i = 0;
        while (i < nums.length) {
            if (nums[i] <= cap) {
                robbed++;
                i += 2; // Skip the next house
            } else {
                i++;
            }
        }
        return robbed >= k;
    }
}
