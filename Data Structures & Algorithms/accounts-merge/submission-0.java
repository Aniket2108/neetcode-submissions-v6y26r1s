class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet ds = new DisjointSet(n);
        Map<String,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=1;j<accounts.get(i).size();j++){
                String mail = accounts.get(i).get(j);
                if(!map.containsKey(mail)){
                    map.put(mail,i);
                }
                else{
                    ds.unionBySize(i,map.get(mail));
                }
            }
        }

        List<String>[] mergedMails = new ArrayList[n];

        for(int i=0;i<n;i++){
            mergedMails[i] = new ArrayList<>();
        }

        for(Map.Entry<String,Integer> entry:map.entrySet()){
            String mail = entry.getKey();
            int node = ds.findUPar(entry.getValue());
            mergedMails[node].add(mail);
        }

        List<List<String>> res = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(mergedMails[i].size() == 0) continue;
            Collections.sort(mergedMails[i]);
            List<String> tmp = new ArrayList<>();
            tmp.add(accounts.get(i).get(0));
            for(String str:mergedMails[i])
            tmp.add(str);
            res.add(tmp);
        }
        return res;
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