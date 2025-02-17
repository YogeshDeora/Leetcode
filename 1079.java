// https://leetcode.com/problems/letter-tile-possibilities/description/?envType=daily-question&envId=2025-02-17


import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numTilePossibilities(String tiles) {
        Set<String> set = new HashSet<>();
        boolean[] used = new boolean[tiles.length()];
        char[] chars = tiles.toCharArray();
        backtrack(chars, used, new StringBuilder(), set);
        return set.size();
    }

    private void backtrack(char[] chars, boolean[] used, StringBuilder sb, Set<String> set) {
        if (sb.length() > 0) {
            set.add(sb.toString());
        }

        for (int i = 0; i < chars.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            sb.append(chars[i]);
            backtrack(chars, used, sb, set);
            sb.deleteCharAt(sb.length() - 1);
            used[i] = false;
        }
    }
}
