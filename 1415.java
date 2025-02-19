// https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/description/?envType=daily-question&envId=2025-02-19

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getHappyString(int n, int k) {
        List<String> happyStrings = new ArrayList<>();
        generateHappyStrings("", n, happyStrings);
        if (happyStrings.size() < k) return "";
        return happyStrings.get(k - 1);
    }
    
    private void generateHappyStrings(String current, int n, List<String> happyStrings) {
        if (current.length() == n) {
            happyStrings.add(current);
            return;
        }
        for (char ch : new char[] {'a', 'b', 'c'}) {
            if (current.isEmpty() || current.charAt(current.length() - 1) != ch) {
                generateHappyStrings(current + ch, n, happyStrings);
            }
        }
    }
}
