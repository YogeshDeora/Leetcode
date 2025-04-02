// https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i/submissions/1594067921/?envType=daily-question&envId=2025-04-02

class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxVal = 0; 
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    long value = (long) (nums[i] - nums[j]) * nums[k];
                    maxVal = Math.max(maxVal, value);
                }
            }
        }
        return maxVal;
    }
}
