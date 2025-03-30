// https://leetcode.com/problems/partition-labels/description/?envType=daily-question&envId=2025-03-30

import java.util.*;

class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        Map<Character, Integer> lastIndex = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, lastIndex.get(s.charAt(i)));

            if (i == end) {
                result.add(end - start + 1);
                start = i + 1;
            }
        }

        return result;
    }
}
