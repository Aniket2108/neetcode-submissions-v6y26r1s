class Solution {
    public int maxProfit(int[] prices) {
       Integer[][] dp = new Integer[prices.length][2];
        return max(0,1,prices,dp);
    }

    public int max(int idx,int buy,int[] prices,Integer[][] dp){
        if(idx >= prices.length) return 0;
        if(dp[idx][buy] != null) return dp[idx][buy];
        
        if(buy == 1){
            dp[idx][buy] = Math.max(-prices[idx] + max(idx+1,0,prices,dp),max(idx+1,1,prices,dp));
        }
        else{
            dp[idx][buy] = Math.max(prices[idx] + max(idx+2,1,prices,dp),max(idx+1,0,prices,dp));
        }
        return dp[idx][buy];
    }
}