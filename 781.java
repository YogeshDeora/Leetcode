// https://leetcode.com/problems/rabbits-in-forest/submissions/1612483167/?envType=daily-question&envId=2025-04-20

import java.util.*;

class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int totalRabbits = 0;

        for (int answer : answers) {
            countMap.put(answer, countMap.getOrDefault(answer, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int x = entry.getKey(); 
            int count = entry.getValue(); 

            int groupSize = x + 1;
            int groups = (count + groupSize - 1) / groupSize; 
            totalRabbits += groups * groupSize;
        }

        return totalRabbits;
    }
}
