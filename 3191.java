// https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-to-one-i/description/?envType=daily-question&envId=2025-03-19

class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int operations = 0;
        for (int i = 0; i < n - 2; i++) {

            if (nums[i] == 0) {

                nums[i] = 1;
                nums[i + 1] = nums[i + 1] == 0 ? 1 : 0;
                nums[i + 2] = nums[i + 2] == 0 ? 1 : 0;
                operations++;
            }
        }

        for (int num : nums) {
            if (num == 0) {
                return -1; 
            }
        }
        
        return operations;
    }
}
