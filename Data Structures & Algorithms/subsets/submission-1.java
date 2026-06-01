class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        subsets(0,nums,new ArrayList<>());
        return res;
    }

    public void subsets(int i,int[] nums,List<Integer> list){
        if(i == nums.length){
        res.add(new ArrayList<>(list));
        return;
        }
        list.add(nums[i]);
        subsets(i+1,nums,list);
        list.remove(list.size()-1);
        subsets(i+1,nums,list);
    }
}
