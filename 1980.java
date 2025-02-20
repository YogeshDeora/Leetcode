// https://leetcode.com/problems/find-unique-binary-string/description/?envType=daily-question&envId=2025-02-20

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        char[] result = new char[n];
        for (int i = 0; i < n; i++) {
            result[i] = nums[i].charAt(i) == '0' ? '1' : '0';
        }
        return new String(result);
    }
}
