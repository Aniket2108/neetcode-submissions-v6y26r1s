class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    for(int l=k+1;l<nums.length;l++){
                        long sum = 0;
                        sum+=nums[i];
                        sum+=nums[j];
                        sum+=nums[k];
                        sum+=nums[l];

                        if(sum == target){
                            List<Integer> tmp = new ArrayList<>();
                            tmp.add(nums[i]);
                            tmp.add(nums[j]);
                            tmp.add(nums[k]);
                            tmp.add(nums[l]);
                            tmp.sort(null);
                            set.add(tmp);
                        }
                    }
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>(set);
        return res;
    }
}