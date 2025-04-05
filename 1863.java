// https://leetcode.com/problems/sum-of-all-subset-xor-totals/description/?envType=daily-question&envId=2025-04-05

class Solution {
    public int subsetXORSum(int[] nums) {
        return calculateSubsetXOR(nums, 0, 0);
    }

    private int calculateSubsetXOR(int[] nums, int index, int currentXOR) {
        if (index == nums.length) {
            return currentXOR;
        }
        int include = calculateSubsetXOR(nums, index + 1, currentXOR ^ nums[index]);
        int exclude = calculateSubsetXOR(nums, index + 1, currentXOR);

        return include + exclude;
    }
}

