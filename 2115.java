// https://leetcode.com/problems/find-all-possible-recipes-from-given-supplies/description/?envType=daily-question&envId=2025-03-21

import java.util.*;

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Integer> inDegree = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> supplySet = new HashSet<>(Arrays.asList(supplies));

        for (String recipe : recipes) {
            inDegree.put(recipe, 0);
            graph.put(recipe, new ArrayList<>());
        }

        for (int i = 0; i < recipes.length; i++) {
            String recipe = recipes[i];
            for (String ingredient : ingredients.get(i)) {
                if (!supplySet.contains(ingredient)) {
                    graph.putIfAbsent(ingredient, new ArrayList<>());
                    graph.get(ingredient).add(recipe);
                    inDegree.put(recipe, inDegree.get(recipe) + 1);
                }
            }
        }
        Queue<String> queue = new LinkedList<>();
        for (String recipe : recipes) {
            if (inDegree.get(recipe) == 0) {
                queue.add(recipe);
            }
        }

        List<String> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            String current = queue.poll();
            result.add(current);

            if (graph.containsKey(current)) {
                for (String neighbor : graph.get(current)) {
                    inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                    if (inDegree.get(neighbor) == 0) {
                        queue.add(neighbor);
                    }
                }
            }
        }

        return result;
    }
}
