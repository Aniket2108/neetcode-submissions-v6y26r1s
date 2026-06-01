class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum(0,candidates,target,new ArrayList<>());
        return res;
    }

    public void combinationSum(int i,int[] nums,int target,List<Integer> list){
        if(target == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int idx = i; idx<nums.length; idx++){
            if(idx > i && nums[idx] == nums[idx - 1]) continue;
            if(nums[i] > target) break;
            list.add(nums[idx]);
            combinationSum(idx+1,nums,target - nums[idx],list);
            list.remove(list.size()-1);
        }
    } 
}

