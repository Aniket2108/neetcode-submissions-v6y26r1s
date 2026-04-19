class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        int ans = f(n-1,dp,coins,amount);

        return ans >= (int)1e9 ? -1 : ans;
    }

    public int f(int idx,int[][] dp,int[] coins,int amount){
        if(idx == 0){
            if(amount % coins[0] == 0){
                return amount / coins[0];
            }
            else{
                return (int)1e9;
            }
        }
        if(dp[idx][amount] != -1) return dp[idx][amount];

        int notTake = f(idx-1,dp,coins,amount);
        int take = (int) 1e9;
        if(coins[idx] <= amount){
            take = 1 + f(idx,dp,coins,amount - coins[idx]);
        }
        return dp[idx][amount] = Math.min(take,notTake);
    }
}
