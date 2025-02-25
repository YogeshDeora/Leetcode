// https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/description/?envType=daily-question&envId=2025-02-25

class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1000000007;
        int oddCount = 0;
        int evenCount = 1;
        int currentSum = 0;
        int result = 0;

        for (int num : arr) {
            currentSum += num;

            if (currentSum % 2 == 0) {
                result += oddCount;
                evenCount++;
            } else {
          
                result += evenCount;
                oddCount++;
            }
            result %= mod;
        }

        return result;
    }
}
