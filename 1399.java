// https://leetcode.com/problems/count-largest-group/?envType=daily-question&envId=2025-04-23

class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> groups = new HashMap<>();
        int prevSum = 0;

        for (int i = 1; i <= n; i++) {
            if (i % 10 == 0) {
                prevSum = 0;
                int num = i;
                while (num > 0) {
                    prevSum += num % 10;
                    num /= 10;
                }
            } else {
                prevSum += 1;
            }
            groups.put(prevSum, groups.getOrDefault(prevSum, 0) + 1);
        }

        int maxSize = Collections.max(groups.values());

        int res = 0;
        for (int count : groups.values()) {
            if (count == maxSize) res++;
        }

        return res;
    }
}
