// https://leetcode.com/problems/divide-array-into-equal-pairs/?envType=daily-question&envId=2025-03-17

import java.util.HashMap;

class Solution {
    public boolean divideArray(int[] nums) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }
        for (int count : frequency.values()) {
            if (count % 2 != 0) {
                return false;
            }
        }
        
        return true;
    }
}
