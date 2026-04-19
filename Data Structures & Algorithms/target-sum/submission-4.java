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

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        return f(n-1,dp,nums,sum);
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
