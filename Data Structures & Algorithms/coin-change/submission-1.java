class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0;i<=amount;i++){
            if(i % coins[0] == 0){
                dp[0][i] = i / coins[0];
            }
            else{
                dp[0][i] = (int)1e9;
            }
        }
        
        for(int i=1;i<n;i++){
            for(int target=0;target<=amount;target++){
                int notTake = dp[i-1][target];
                int take = (int) 1e9;
                if(coins[i] <= target){
                take = 1 + dp[i][target - coins[i]];
                }
                dp[i][target] = Math.min(take,notTake);
            }
        }

        int ans = dp[n-1][amount];

        return ans >= (int)1e9 ? -1 : ans;
    }

}