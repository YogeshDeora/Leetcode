https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/?envType=daily-question&envId=2025-02-12

import java.util.HashMap;

class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxSum = -1;
        
        for (int num : nums) {
            int sumOfDigits = getDigitSum(num);
            if (map.containsKey(sumOfDigits)) {
                maxSum = Math.max(maxSum, map.get(sumOfDigits) + num);
            }
            map.put(sumOfDigits, Math.max(map.getOrDefault(sumOfDigits, 0), num));
        }
        
        return maxSum;
    }
    
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
