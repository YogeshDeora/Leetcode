// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/submissions/1570156653/?envType=daily-question&envId=2025-03-11
class Solution {
    public int numberOfSubstrings(String s) {
        int[] count = {0, 0, 0}; 
        int left = 0;           
        int total = 0;          

        for (int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'a']++;
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                total += s.length() - right; 
                count[s.charAt(left) - 'a']--; 
                left++; 
            }
        }

        return total;
    }
}
