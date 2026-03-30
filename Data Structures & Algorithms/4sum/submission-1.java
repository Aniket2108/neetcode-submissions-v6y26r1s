class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                Set<Long> st = new HashSet<>();
                for(int k=j+1;k<nums.length;k++){
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[k];
                    long tar = target - sum;
                    if(st.contains(tar)){
                            List<Integer> tmp = new ArrayList<>();
                            tmp.add(nums[i]);
                            tmp.add(nums[j]);
                            tmp.add(nums[k]);
                            tmp.add((int)tar);
                            tmp.sort(null);
                            set.add(tmp);
                        
                    }
                    st.add((long)nums[k]);
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>(set);
        return res;
    }
}