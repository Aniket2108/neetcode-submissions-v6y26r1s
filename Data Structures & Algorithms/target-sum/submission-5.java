class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totSum = 0;
        for(int i:nums){
            totSum += i;
        }

        if(totSum < Math.abs(target) || (target + totSum)%2 != 0) return 0;

        int sum = (target + totSum)/2;
        int n = nums.length;

        int[][] dp = new int[n][sum+1];
        if(nums[0] == 0){
            dp[0][0] = 2;
        }
        else{
            dp[0][0] = 1;
        }

        if(nums[0] != 0 && nums[0] <= sum){
            dp[0][nums[0]] = 1;
        }

        for(int i=1;i<n;i++){
            for(int t=0;t<=sum;t++){
                int notTake = dp[i-1][t];
                int take = 0;
                if(nums[i] <= t){
                    take = dp[i-1][t-nums[i]];
                }

            dp[i][t] = take + notTake;
            }
        }
        

        return dp[n-1][sum];
    }

    public int f(int idx,int[][] dp,int[] nums,int target){
        if(idx == 0){
            if(target == 0 && nums[0] == 0) return 2;
            if(target == 0 || nums[0] == target) return 1;
            return 0;
        }
        if(dp[idx][target] != -1) return dp[idx][target];

        int notTake = f(idx-1,dp,nums,target);
        int take = 0;
        if(nums[idx] <= target){
            take = f(idx-1,dp,nums,target - nums[idx]);
        }

        return dp[idx][target] = take + notTake;
    }
}
