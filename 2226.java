// https://leetcode.com/problems/maximum-candies-allocated-to-k-children/description/?envType=daily-question&envId=2025-03-14

class Solution {
    public int maximumCandies(int[] candies, long k) {
        int low = 0, high = Integer.MAX_VALUE; 
        int result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canDistribute(candies, k, mid)) {
                result = mid; 
                low = mid + 1; 
            } else {
                high = mid - 1; 
            }
        }

        return result;
    }

    private boolean canDistribute(int[] candies, long k, int candiesPerChild) {
        if (candiesPerChild == 0) return true; 
        long totalChildren = 0;

        for (int pile : candies) {
            totalChildren += pile / candiesPerChild; 
            if (totalChildren >= k) return true; 
        }

        return totalChildren >= k;
    }
}
