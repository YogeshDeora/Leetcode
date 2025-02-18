// https://leetcode.com/problems/construct-smallest-number-from-di-string/description/?envType=daily-question&envId=2025-02-18

class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        StringBuilder result = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int num = 1;
        
        for (int i = 0; i <= n; i++) {
            stack.push(num++);
            if (i == n || pattern.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    result.append(stack.pop());
                }
            }
        }
        
        return result.toString();
    }
}
