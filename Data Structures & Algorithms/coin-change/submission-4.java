class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[] prev = new int[amount+1];
        int[] cur = new int[amount+1];
        for(int i=0;i<=amount;i++){
            if(i % coins[0] == 0){
                prev[i] = i / coins[0];
            }
            else{
                prev[i] = (int)1e9;
            }
        }
        
        for(int i=1;i<n;i++){
            for(int target=0;target<=amount;target++){
                int notTake = prev[target];
                int take = (int) 1e9;
                if(coins[i] <= target){
                take = 1 + cur[target - coins[i]];
                }
                cur[target] = Math.min(take,notTake);
            }
            prev = cur;
        }

        int ans = prev[amount];

        return ans >= (int)1e9 ? -1 : ans;
    }

}