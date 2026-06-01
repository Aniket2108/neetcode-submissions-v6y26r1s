class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subsetsWithDup(0,nums,new ArrayList<>());
        return res;
    }

    private void subsetsWithDup(int start,int[] nums,List<Integer> list){
        res.add(new ArrayList<>(list));

        for(int i=start;i<nums.length;i++){
            if(i > start && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            subsetsWithDup(i+1,nums,list);
            list.remove(list.size()-1);
        }
    }
}
