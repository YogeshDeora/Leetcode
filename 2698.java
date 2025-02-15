// https://leetcode.com/problems/find-the-punishment-number-of-an-integer/description/?envType=daily-question&envId=2025-02-15

public class Solution {
    static boolean canBePartitioned(int original, String squareStr) {
        int n = squareStr.length();
        return canPartitionHelper(original, squareStr, 0, 0);
    }

    static boolean canPartitionHelper(int original, String squareStr, int index, int currentSum) {
        if (index == squareStr.length()) {
            return currentSum == original;
        }
        for (int i = index; i < squareStr.length(); i++) {
            int part = Integer.parseInt(squareStr.substring(index, i + 1));
            if (canPartitionHelper(original, squareStr, i + 1, currentSum + part)) {
                return true;
            }
        }
        return false;
    }

    public int punishmentNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int square = i * i;
            if (canBePartitioned(i, String.valueOf(square))) {
                sum += square;
            }
        }
        return sum;
    }

}
