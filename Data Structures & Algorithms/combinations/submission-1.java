class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        combine(1,n,k,new ArrayList<>());
        return res;
    }

    private void combine(int i,int n,int k,List<Integer> list){
        if(list.size() == k){
            res.add(new ArrayList<>(list));
            return;
        }
        if(i > n){
            return;
        }
        list.add(i);
        combine(i+1,n,k,list);
        list.remove(list.size()-1);
        combine(i+1,n,k,list);
    }
}