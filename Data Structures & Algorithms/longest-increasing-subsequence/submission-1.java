class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        
        for(int i=n-1;i>=0;i--){
            for(int prevIdx=i-1;prevIdx>=-1;prevIdx--){
                int notTake = dp[i+1][prevIdx+1];
                int take = 0;
                if(prevIdx == -1 || nums[i] > nums[prevIdx]){
                    take = 1 + dp[i+1][i+1];
                }
            dp[i][prevIdx+1] = Math.max(take,notTake);
            }
        }
        return dp[0][0];
    }

}
