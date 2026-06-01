class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        permute(nums,visited,new ArrayList<>());
        return res;
    }

    private void permute(int[] nums,boolean[] visited,List<Integer> list){
        if(nums.length == list.size()){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(visited[i])continue;
            list.add(nums[i]);
            visited[i] = true;
            permute(nums,visited,list);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }
}
