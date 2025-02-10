// https://leetcode.com/problems/clear-digits/description/?envType=daily-question&envId=2025-02-10

// You are given a string s.

// Your task is to remove all digits by doing this operation repeatedly:

// Delete the first digit and the closest non-digit character to its left.
// Return the resulting string after removing all digits.

 

// Example 1:

// Input: s = "abc"

// Output: "abc"

// Explanation:

// There is no digit in the string.

// Example 2:

// Input: s = "cb34"

// Output: ""

// Explanation:

// First, we apply the operation on s[2], and s becomes "c4".

// Then we apply the operation on s[1], and s becomes "".

 

// Constraints:

// 1 <= s.length <= 100
// s consists only of lowercase English letters and digits.
// The input is generated such that it is possible to delete all digits.


public class Leetcode_3174 {
    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        while (true) {
            boolean foundDigit = false;
            
            for (int i = 0; i < sb.length(); i++) {
                if (Character.isDigit(sb.charAt(i))) {
                    foundDigit = true;
                    
                   
                    int leftIndex = i - 1;
                    while (leftIndex >= 0 && Character.isDigit(sb.charAt(leftIndex))) {
                        leftIndex--;
                    }
                    
                    if (leftIndex >= 0) {
                        sb.deleteCharAt(leftIndex);
                        sb.deleteCharAt(leftIndex); 
                    } else {
                        sb.deleteCharAt(i);
                    }
                    
                    break;
                }
            }
            
            if (!foundDigit) {
                break;
            }
        }
        
        return sb.toString();
    }
}
