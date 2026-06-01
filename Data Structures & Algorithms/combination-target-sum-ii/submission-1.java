class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combinationSum(0,candidates,0,target,new ArrayList<>());
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
        combinationSum(i+1,nums,sum+nums[i],target,list);
        list.remove(list.size()-1);
        int j = i;
        while (j + 1 < nums.length && nums[j] == nums[j + 1]) {
            j++;
        }
        combinationSum(j+1,nums,sum,target,list);
    } 
}

