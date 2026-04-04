class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        dfs(1,n,k,new ArrayList<>());
        return list;
    }

    public void dfs(int i,int n,int k,List<Integer> tmp){
        if(tmp.size() == k){
            list.add(new ArrayList<>(tmp));
            return;
        }
        if(i>n){
            return;
        }

        tmp.add(i);
        dfs(i+1,n,k,tmp);

        tmp.remove(tmp.size()-1);
        dfs(i+1,n,k,tmp);
    }
}