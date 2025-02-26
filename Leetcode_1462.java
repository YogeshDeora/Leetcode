// https://leetcode.com/problems/course-schedule-iv/description/?envType=daily-question&envId=2025-01-27


import java.util.*;

class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] prereq : prerequisites) {
            int a = prereq[0];
            int b = prereq[1];
            graph[a].add(b);
        }

        boolean[][] reach = new boolean[numCourses][numCourses];
        
        for (int i = 0; i < numCourses; i++) {
            dfs(i, graph, reach);
        }

        List<Boolean> result = new ArrayList<>();
        for (int[] query : queries) {
            int u = query[0];
            int v = query[1];
            result.add(reach[u][v]);
        }
        
        return result;
    }
    
    private void dfs(int node, List<Integer>[] graph, boolean[][] reach) {
        Stack<Integer> stack = new Stack<>();
        stack.push(node);
        Set<Integer> visited = new HashSet<>();
        visited.add(node);
        
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            for (int neighbor : graph[curr]) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    stack.push(neighbor);
                    reach[node][neighbor] = true;
                }
            }
        }
    }
}
