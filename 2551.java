// https://leetcode.com/problems/put-marbles-in-bags/?envType=daily-question&envId=2025-03-31

import java.util.Arrays;

class Solution {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length;
        if (k == 1 || k == n) return 0;
        int[] pairCosts = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            pairCosts[i] = weights[i] + weights[i + 1];
        }
        Arrays.sort(pairCosts);
        long maxScore = 0, minScore = 0;
        for (int i = 0; i < k - 1; i++) {
            minScore += pairCosts[i]; 
            maxScore += pairCosts[n - 2 - i]; 
        }
        return maxScore - minScore;
    }
}
