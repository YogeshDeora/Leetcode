// https://leetcode.com/problems/find-numbers-with-even-number-of-digits/?envType=daily-question&envId=2025-04-30

class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (hasEvenNumberOfDigits(num)) {
                count++;
            }
        }
        return count;
    }

    private boolean hasEvenNumberOfDigits(int num) {
        int digitCount = 0;
        while (num > 0) {
            num /= 10;
            digitCount++;
        }
        return digitCount % 2 == 0;
    }
}
