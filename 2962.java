// https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/?envType=daily-question&envId=2025-04-29

class Solution {
    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int maxVal = 0;
        for (int v : nums) maxVal = Math.max(maxVal, v);

        long res = 0;
        int count = 0, left = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] == maxVal) count++;
            while (count >= k) {
                if (nums[left] == maxVal) count--;
                left++;
            }
            res += left;
        }
        return res;
    }
}
