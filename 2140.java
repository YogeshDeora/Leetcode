// https://leetcode.com/problems/solving-questions-with-brainpower/description/?envType=daily-question&envId=2025-04-01

class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[n + 1]; 
        for (int i = n - 1; i >= 0; i--) {
            int points = questions[i][0];    
            int skip = questions[i][1];      
            long solve = points + ((i + skip + 1 < n) ? dp[i + skip + 1] : 0);
            long skipQuestion = dp[i + 1];
            dp[i] = Math.max(solve, skipQuestion);
        }
        return dp[0]; 
    }
}
