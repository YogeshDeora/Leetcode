
// https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/description/?envType=daily-question&envId=2025-02-22

import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

public class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int i = 0;
        while (i < traversal.length()) {
            int level = 0;
            while (i < traversal.length() && traversal.charAt(i) == '-') {
                level++;
                i++;
            }
            int val = 0;
            while (i < traversal.length() && Character.isDigit(traversal.charAt(i))) {
                val = val * 10 + (traversal.charAt(i) - '0');
                i++;
            }
            TreeNode node = new TreeNode(val);
            while (stack.size() > level) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }
            stack.push(node);
        }
        while (stack.size() > 1) {
            stack.pop();
        }
        return stack.pop();
    }
}
