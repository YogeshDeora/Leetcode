// https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/description/?envType=daily-question&envId=2025-03-12

class Solution {
    public int maximumCount(int[] nums) {
        int negCount = firstNonNegativeIndex(nums);
        int posCount = nums.length - firstPositiveIndex(nums);
        return Math.max(negCount, posCount);
    }

    private int firstNonNegativeIndex(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= 0) {
                high = mid - 1; 
            } else {
                low = mid + 1;  
            }
        }
        return low;
    }

    private int firstPositiveIndex(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > 0) {
                high = mid - 1; 
            } else {
                low = mid + 1;  
            }
        }
        return low;
    }
}
