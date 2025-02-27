// https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/submissions/1557139660/?envType=daily-question&envId=2025-02-27

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }
        
        int maxLength = 0;
        Map<Integer, Integer> longest = new HashMap<>();
        
        for (int k = 0; k < n; k++) {
            for (int j = 0; j < k; j++) {
                int i = indexMap.getOrDefault(arr[k] - arr[j], -1);
                if (i >= 0 && i < j) {
                    int length = longest.getOrDefault(i * n + j, 2) + 1;
                    longest.put(j * n + k, length);
                    maxLength = Math.max(maxLength, length);
                }
            }
        }
        
        return maxLength >= 3 ? maxLength : 0;
    }
}
