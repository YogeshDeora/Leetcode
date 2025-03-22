// https://leetcode.com/problems/count-the-number-of-complete-components/description/?envType=daily-question&envId=2025-03-22

import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        int completeCount = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, graph, visited, component);
                if (isComplete(component, graph)) {
                    completeCount++;
                }
            }
        }
        
        return completeCount;
    }
    
    private void dfs(int node, List<List<Integer>> graph, boolean[] visited, List<Integer> component) {
        visited[node] = true;
        component.add(node);
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, graph, visited, component);
            }
        }
    }
    
    private boolean isComplete(List<Integer> component, List<List<Integer>> graph) {
        int size = component.size();
        int expectedEdges = size * (size - 1) / 2;
        int actualEdges = 0;
        
        for (int node : component) {
            actualEdges += graph.get(node).size();
        }
        actualEdges /= 2;
        
        return actualEdges == expectedEdges;
    }
}
