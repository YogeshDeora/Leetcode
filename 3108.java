// https://leetcode.com/problems/minimum-cost-walk-in-weighted-graph/description/?envType=daily-question&envId=2025-03-20

class Disjoint{
    int par[];
    int size[];
    int cost[];
    Disjoint(int n){
        par = new int[n];
        size = new int[n];
        cost = new int[n];
        for(int i=0;i<n;i++){
            par[i] = i;
            cost[i]= 0b1_1111_1111_1111_1111; //10^5 MAXM
        }
    }
    public int getParent(int x){
        if(x==par[x]) return x;
        return par[x] = getParent(par[x]);
    }
    public int find(int u,int v){
        int par_u = getParent(u);
        int par_v = getParent(v);
        if(par_u != par_v) return -1;
        return cost[par_u];
    }
    public void dsu(int u,int v,int wt){
        int par_u = getParent(u);
        int par_v = getParent(v);
        int newcost = cost[par_u] & cost[par_v] & wt;
        if(par_u == par_v){
            cost[par_u] = newcost;
            return;
        }
        else if(size[par_u]>size[par_v]){
            par[par_v] = par_u;
            size[par_u] += size[par_v];
            cost[par_u] = newcost;
        }
        else{
            par[par_u]= par_v;
            size[par_v] += size[par_u];
            cost[par_v] = newcost;
        }
    }
}
class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        int ans[] = new int[query.length];
        Disjoint ds = new Disjoint(n);
        for(int ed[]:edges){
            ds.dsu(ed[0],ed[1],ed[2]);
        }
        int ind = 0;
        for(int q[]: query){
            ans[ind++] = ds.find(q[0],q[1]);
        }
        return ans;
    }
}
