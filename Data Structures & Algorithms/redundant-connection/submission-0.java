class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet ds = new DisjointSet(n+1);

        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];

            if(ds.findUPar(u) == ds.findUPar(v)){
                return edge;
            }
            ds.unionBySize(u,v);
        }
        return new int[]{};
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