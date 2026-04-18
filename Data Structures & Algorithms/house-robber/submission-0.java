class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return dp(n-1,nums,dp);
    }

    public int dp(int n,int[] nums,int[] dp){
        if(n == 0) return nums[n];
        if(n < 0) return 0;
        if(dp[n] != -1) return dp[n];

        int take = nums[n] + dp(n-2,nums,dp);
        int notTake = dp(n-1,nums,dp);

        return dp[n] = Math.max(take,notTake);
    }
}
