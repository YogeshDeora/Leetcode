// https://leetcode.com/problems/count-subarrays-with-fixed-bounds/submissions/1618626277/?envType=daily-question&envId=2025-04-26

class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int pMin = -1, pMax = -1, bad = -1;
        long ans = 0;
        
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] == minK) pMin = i;
            if (nums[i] == maxK) pMax = i;
            if (nums[i] < minK || nums[i] > maxK) bad = i;
            if (pMin != -1 && pMax != -1) {
                ans += Math.max(0, Math.min(pMin, pMax) - bad);
            }
        }
        return ans;
    }
}
