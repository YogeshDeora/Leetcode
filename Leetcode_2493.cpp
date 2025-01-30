// https://leetcode.com/problems/divide-nodes-into-the-maximum-number-of-groups/description/?envType=daily-question&envId=2025-01-30

// 2493. Divide Nodes Into the Maximum Number of Groups
// Solved
// Hard
// Topics
// Companies
// Hint
// You are given a positive integer n representing the number of nodes in an undirected graph. The nodes are labeled from 1 to n.

// You are also given a 2D integer array edges, where edges[i] = [ai, bi] indicates that there is a bidirectional edge between nodes ai and bi. Notice that the given graph may be disconnected.

// Divide the nodes of the graph into m groups (1-indexed) such that:

// Each node in the graph belongs to exactly one group.
// For every pair of nodes in the graph that are connected by an edge [ai, bi], if ai belongs to the group with index x, and bi belongs to the group with index y, then |y - x| = 1.
// Return the maximum number of groups (i.e., maximum m) into which you can divide the nodes. Return -1 if it is impossible to group the nodes with the given conditions.

 

// Example 1:


// Input: n = 6, edges = [[1,2],[1,4],[1,5],[2,6],[2,3],[4,6]]
// Output: 4
// Explanation: As shown in the image we:
// - Add node 5 to the first group.
// - Add node 1 to the second group.
// - Add nodes 2 and 4 to the third group.
// - Add nodes 3 and 6 to the fourth group.
// We can see that every edge is satisfied.
// It can be shown that that if we create a fifth group and move any node from the third or fourth group to it, at least on of the edges will not be satisfied.
// Example 2:

// Input: n = 3, edges = [[1,2],[2,3],[3,1]]
// Output: -1
// Explanation: If we add node 1 to the first group, node 2 to the second group, and node 3 to the third group to satisfy the first two edges, we can see that the third edge will not be satisfied.
// It can be shown that no grouping is possible.
 

// Constraints:

// 1 <= n <= 500
// 1 <= edges.length <= 104
// edges[i].length == 2
// 1 <= ai, bi <= n
// ai != bi
// There is at most one edge between any pair of vertices.


class Solution {
public:
    
   bool dfs(vector<vector<int>>& graph, vector<int> &color, int v, int c){
        color[v] = c;
        for(int i=0;i<graph[v].size();i++){
            if(color[graph[v][i]] == c) return false;
            if(color[graph[v][i]] == 0){
                bool test = dfs(graph, color, graph[v][i], -c);
                if(!test) return false;
            }
        }
        return true;
    }
    int cheklevel(int node,vector<vector<int>>&graph,int n){
  vector<int>vis(n+1);
    queue<int>pq;
    pq.push(node);
    vis[node]=1;
    vector<vector<int>>level;
    
    while(pq.size()>0){
        int sz=pq.size();
        vector<int>res;
        for(int i=0;i<sz;i++){
            int x=pq.front();
            pq.pop();
            res.push_back(x);
            for(auto nebr:graph[x]){
                if(vis[nebr]==0){
                    pq.push(nebr);
                    vis[nebr]=1;
                }
            }
        }
        level.push_back(res);
    }
    return level.size();
}
    int curlevel(int node,vector<vector<int>>&graph,int n,vector<int>&vis){
  vector<int>cur;
  cur.push_back(node);
  vis[node]=1;
        int mx=cheklevel(node,graph,n);
  while ( 1)
  {
    vector<int>next;
    for ( int i = 0; i <  cur.size(); i++)
    {
       for(auto nebr:graph[cur[i]]){
        if(vis[nebr]==0){
          next.push_back(nebr);
            mx=max(mx,cheklevel(nebr,graph,n));
          vis[nebr]=1;
        }
       }
    }
    if(next.size()==0){
      break;
    }
    cur=next;
  }

  sort(cur.begin(),cur.end());

  return mx;
 }  
    int magnificentSets(int n, vector<vector<int>>&v) {
         vector<vector<int>>graph;
 
        vector<int> color(n+1, 0);
        graph.resize(n+1);
        for(int i=0;i<v.size();i++){
            graph[v[i][0]].push_back(v[i][1]);
            graph[v[i][1]].push_back(v[i][0]);
        }
        for(int i=0;i<n;i++){
            if(color[i] == 0){
                if(!dfs(graph, color, i, 1)){
                    return -1;
                }
            }
        }
        int ans=0;
        vector<vector<int>>level;
        vector<int>vis(n+1,0);
        for(int i=1;i<=n;i++){
            if(vis[i]==0){
                 ans+=curlevel(i,graph,n,vis);
               
            }
        }
        return ans; 
    }
};