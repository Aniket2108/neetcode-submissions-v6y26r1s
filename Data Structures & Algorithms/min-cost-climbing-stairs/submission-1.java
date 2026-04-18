class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
       
        if(n == 0 || n == 1) return 0;
        
        int prev = 0, prev2 = 0;

        for(int i=2;i<=n;i++){
            int cur = Math.min(prev + cost[i-1], prev2 + cost[i-2]);
            prev2 = prev;
            prev = cur;
        }

        return prev;
    }
}
