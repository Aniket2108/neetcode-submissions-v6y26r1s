class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(0,nums,new ArrayList<>());
        return list;
    }

    public void dfs(int start,int[] nums,List<Integer> tmp){
        list.add(new ArrayList<>(tmp));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) continue;

            tmp.add(nums[i]);
            dfs(i + 1, nums, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
