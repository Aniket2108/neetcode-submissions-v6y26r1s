class Solution {
    public int change(int amount, int[] coins) {
int n = coins.length;
        int[][] dp = new int[n][amount+1];
        
        for(int i=0;i<=amount;i++){
            dp[0][i] = i % coins[0] == 0 ? 1 : 0;
        }

        for(int i=1;i<n;i++){
            for(int t=0;t<=amount;t++){
                int notTake = dp[i-1][t];
                int take = 0;
                if(coins[i] <= t){
                    take = dp[i][t - coins[i]];
                }
            dp[i][t] = take + notTake;
            }
        }
        

        return dp[n-1][amount];
    }

}