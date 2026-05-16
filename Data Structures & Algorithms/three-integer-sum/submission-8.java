class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    List<Integer> tmp = new ArrayList<>();

                    long sum = nums[i] + nums[j];
                    sum += nums[k];

                    if(sum == 0){
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        Collections.sort(tmp);
                        set.add(tmp);
                    }
                }
            }
        }

        List<List<Integer>> res = new ArrayList<>(set);
        return res;
    }
}
