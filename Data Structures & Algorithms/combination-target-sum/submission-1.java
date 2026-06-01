class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        combinationSum(0,nums,0,target,new ArrayList<>());
        return res;
    }

    public void combinationSum(int i,int[] nums,int sum,int target,List<Integer> list){
        if(sum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        if(i == nums.length || sum > target){
            return;
        }
        list.add(nums[i]);
        combinationSum(i,nums,sum+nums[i],target,list);
        list.remove(list.size()-1);
        combinationSum(i+1,nums,sum,target,list);
    } 
}
