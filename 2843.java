// https://leetcode.com/problems/count-symmetric-integers/description/?envType=daily-question&envId=2025-04-11

class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        
        for (int num = low; num <= high; num++) {
            String strNum = String.valueOf(num);
            int len = strNum.length();
            
            // Only consider numbers with an even number of digits
            if (len % 2 == 0) {
                int n = len / 2;
                int sumFirstHalf = 0, sumSecondHalf = 0;

                for (int i = 0; i < n; i++) {
                    sumFirstHalf += strNum.charAt(i) - '0';
                    sumSecondHalf += strNum.charAt(len - n + i) - '0';
                }

                if (sumFirstHalf == sumSecondHalf) {
                    count++;
                }
            }
        }
        
        return count;
    }
}


