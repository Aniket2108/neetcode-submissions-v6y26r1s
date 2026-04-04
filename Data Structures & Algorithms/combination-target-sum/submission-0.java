class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        dfs(0,nums,0,target,new ArrayList<>());
        return list;
    }

    public void dfs(int i,int[] nums,int sum,int target,List<Integer> curr){
        if(sum == target){
            list.add(new ArrayList<>(curr));
            return;
        }
        if(i==nums.length || sum > target) return;

        curr.add(nums[i]);
        dfs(i,nums,sum+nums[i],target,curr);

        curr.remove(curr.size()-1);
        dfs(i+1,nums,sum,target,curr);
        
    }
}
