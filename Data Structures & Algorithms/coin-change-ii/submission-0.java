class Solution {
    public int change(int amount, int[] coins) {
int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        int ans = f(n-1,dp,coins,amount);

        return ans;
    }

    public int f(int idx,int[][] dp,int[] coins,int amount){
        if(idx == 0){
            if(amount % coins[0] == 0){
                return 1;
            }
            return 0;
        }
        if(dp[idx][amount] != -1) return dp[idx][amount];

        int notTake = f(idx-1,dp,coins,amount);
        int take = 0;
        if(coins[idx] <= amount){
            take = f(idx,dp,coins,amount - coins[idx]);
        }
        return dp[idx][amount] = take + notTake;
    }
}