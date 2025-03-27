// https://leetcode.com/problems/minimum-index-of-a-valid-split/?envType=daily-question&envId=2025-03-27

import java.util.*;

class Solution {
    public int minimumIndex(List<Integer> nums) {
        int dominant = findDominant(nums);
        int leftCount = 0; 
        int totalCount = 0; 
        for (int num : nums) {
            if (num == dominant) {
                totalCount++;
            }
        }
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == dominant) {
                leftCount++;
            }
            int rightCount = totalCount - leftCount;
            if (leftCount * 2 > i + 1 && rightCount * 2 > nums.size() - i - 1) {
                return i;
            }
        }
        return -1;
    }

    private int findDominant(List<Integer> nums) {
        int candidate = -1;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
