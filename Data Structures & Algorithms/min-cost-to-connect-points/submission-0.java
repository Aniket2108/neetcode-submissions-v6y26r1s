class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        DisjointSet ds = new DisjointSet(n);

        List<int[]> edges = new ArrayList<>();

        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{dist,i,j});
            }
        }

        edges.sort((a,b) -> Integer.compare(a[0],b[0]));

        int cost = 0;
        int edgesUsed = 0;
        for(int[] edge : edges){
            int wt = edge[0];
            int u = edge[1];
            int v = edge[2];

            if(ds.findUPar(u) != ds.findUPar(v)){
                ds.unionBySize(u, v);
                cost += wt;
                edgesUsed++;

                if(edgesUsed == n - 1) break; 
            }
        }

        return cost;
        
    }
}
class DisjointSet{
    List<Integer> size;
    List<Integer> parent;

    public DisjointSet(int n){
        size = new ArrayList<>();
        parent = new ArrayList<>();

        for(int i=0;i<n;i++){
            size.add(1);
            parent.add(i);
        }
    }

    public int findUPar(int node){
        if(node == parent.get(node)) return node;
        int ulP = findUPar(parent.get(node));
        parent.set(node,ulP);
        return parent.get(node);
    }

    public void unionBySize(int u,int v){
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);

        if(size.get(ulp_u) < size.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u) + size.get(ulp_v));
        }
        else{
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u,size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
