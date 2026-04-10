class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int[] vis = new int[n];
        int cnt = 0;

        for(int i=0;i<vis.length;i++){
            if(vis[i] == 0){
                cnt++;
                dfs(i,vis,adj);
            }
        }
        return cnt;
    }

    public void dfs(int node,int[] vis,List<List<Integer>> adj){
        vis[node] = 1;
        for(int adjnode:adj.get(node)){
            if(vis[adjnode] == 0){
                dfs(adjnode,vis,adj);
            }
        }
    }
}
