class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totSum = 0;
        for(int i:nums){
            totSum += i;
        }

        if(totSum < Math.abs(target) || (target + totSum)%2 != 0) return 0;

        int sum = (target + totSum)/2;
        int n = nums.length;

        int[] dp = new int[sum+1];
        if(nums[0] == 0){
            dp[0] = 2;
        }
        else{
            dp[0] = 1;
        }

        if(nums[0] != 0 && nums[0] <= sum){
            dp[nums[0]] = 1;
        }

        for(int i=1;i<n;i++){
            int[] cur = new int[sum+1];
            for(int t=0;t<=sum;t++){
                int notTake = dp[t];
                int take = 0;
                if(nums[i] <= t){
                    take = dp[t-nums[i]];
                }

            cur[t] = take + notTake;
            }
            dp = cur;
        }
        

        return dp[sum];
    }
}