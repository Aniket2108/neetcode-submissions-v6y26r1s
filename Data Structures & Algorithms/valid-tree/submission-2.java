class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] vis = new int[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

       
                if(dfs(0,-1,adj,vis)){
                    return false;
                }
        for(int i = 0; i < n; i++){
            if(vis[i] == 0) return false;
        }

        return true;
    }

    public boolean dfs(int node,int parent,List<List<Integer>> adj,int[] vis){
        vis[node] = 1;

        for(int adjnode:adj.get(node)){
            if(vis[adjnode] == 0){
                if(dfs(adjnode,node,adj,vis)){
                    return true;
                }
            }
            else if(parent != adjnode){
                return true;
            }
        }
        return false;
    }
}
