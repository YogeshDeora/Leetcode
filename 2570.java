// https://leetcode.com/problems/merge-two-2d-arrays-by-summing-values/description/?envType=daily-question&envId=2025-03-02

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        // Create a map to store the id and its corresponding summed value
        Map<Integer, Integer> map = new TreeMap<>();

        // Add values from nums1 to the map
        for (int[] pair : nums1) {
            map.put(pair[0], map.getOrDefault(pair[0], 0) + pair[1]);
        }

        // Add values from nums2 to the map
        for (int[] pair : nums2) {
            map.put(pair[0], map.getOrDefault(pair[0], 0) + pair[1]);
        }

        // Convert the map to a 2D array
        int[][] result = new int[map.size()][2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result[index][0] = entry.getKey();
            result[index][1] = entry.getValue();
            index++;
        }

        return result;
    }
}
