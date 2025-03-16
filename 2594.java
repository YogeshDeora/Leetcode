// https://leetcode.com/problems/minimum-time-to-repair-cars/?envType=daily-question&envId=2025-03-16

import java.util.Arrays;

class Solution {
    public long repairCars(int[] ranks, int cars) {
        long left = 0, right = (long) 1e18; 
        long answer = right;

        while (left <= right) {
            long mid = left + (right - left) / 2; 
            if (canRepairAllCars(ranks, cars, mid)) {
                answer = mid; 
                right = mid - 1; 
            } else {
                left = mid + 1; 
            }
        }

        return answer;
    }

    private boolean canRepairAllCars(int[] ranks, int cars, long time) {
        long totalCars = 0;

        for (int rank : ranks) {
            totalCars += Math.sqrt(time / rank);
            if (totalCars >= cars) {
                return true; 
            }
        }

        return totalCars >= cars;
    }
}
