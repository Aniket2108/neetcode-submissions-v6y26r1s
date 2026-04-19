class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totSum = 0;

        for(int i:nums){
            totSum += i;
        }

        if(totSum%2 == 1) return false;
        else{
            int k = totSum/2;
            boolean[] prev = new boolean[k+1];
            prev[0] = true;
            
            if(nums[0]<=k){
                prev[nums[0]] = true;
            }

            for(int i=1;i<n;i++){
                boolean[] tmp = new boolean[k+1];
                tmp[0] = true;
                for(int target=1;target<=k;target++){
                    boolean notTake = prev[target];
                    boolean take = false;
                    if(nums[i] <= target){
                    take = prev[target - nums[i]];
                    tmp[target] = take || notTake;
                    }
                }
                prev = tmp;
            }

            return prev[k];
            
        }
    }
}
