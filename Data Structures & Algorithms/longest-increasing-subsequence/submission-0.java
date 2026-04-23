class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        Integer[][] dp = new Integer[n][n+1];
    return max(0,-1,nums,dp);
    }

    public int max(int i,int prevIdx,int[] nums,Integer[][] dp){
        if(i == nums.length) return 0;
        if(dp[i][prevIdx+1] != null) return dp[i][prevIdx+1];

        int notTake = max(i+1,prevIdx,nums,dp);
        int take = 0;
        if(prevIdx == -1 || nums[i] > nums[prevIdx]){
            take = 1 + max(i+1,i,nums,dp);
        }
        return dp[i][prevIdx+1] = Math.max(take,notTake);
    }
}
