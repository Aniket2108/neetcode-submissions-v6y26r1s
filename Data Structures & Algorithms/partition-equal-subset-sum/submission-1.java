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
            boolean[][] dp = new boolean[n][k+1];
            for(int i=0;i<n;i++){
                dp[i][0] = true;
            }

            for(int i=0;i<n;i++){
                dp[0][nums[0]] = true;
            }

            for(int i=1;i<n;i++){
                for(int target=1;target<=k;target++){
                    boolean notTake = dp[i-1][target];
                    boolean take = false;
                    if(nums[i] <= target){
                    take = dp[i - 1][target - nums[i]];
                    dp[i][target] = take || notTake;
                    }
                }
            }

            return dp[n-1][k];
            
        }
    }
}
