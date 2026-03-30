class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            Set<Integer> st = new HashSet<>();
            for(int j=i+1;j<nums.length;j++){
                int third = -(nums[i] + nums[j]);
                if(st.contains(third)){
                    List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(third);
                        tmp.sort(null);
                        set.add(tmp);
                    }
                st.add(nums[j]);
                }
            }
        List<List<Integer>> res = new ArrayList<>(set);
        return res;
    }
}
