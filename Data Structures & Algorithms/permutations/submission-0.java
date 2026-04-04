class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
       boolean[] visited = new boolean[nums.length];
       dfs(nums,visited,new ArrayList<>());
        return list;
    }

    public void dfs(int[] nums,boolean[] visited,List<Integer> tmp){
        if(tmp.size() == nums.length){
            list.add(new ArrayList<>(tmp));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(visited[i]) continue;
            visited[i] = true;
            tmp.add(nums[i]);
            dfs(nums,visited,tmp);
            tmp.remove(tmp.size()-1);
            visited[i] = false;
        }
    }
}