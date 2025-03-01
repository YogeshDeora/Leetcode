// https://leetcode.com/problems/apply-operations-to-an-array/description/?envType=daily-question&envId=2025-03-01

class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        
        // Apply the operations
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }
        
        // Move all zeros to the end
        int[] result = new int[n];
        int index = 0;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                result[index++] = nums[i];
            }
        }
        
        return result;
    }
}
