class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totSum = 0;

        for(int i:nums){
            totSum += i;
        }

        if(totSum%2 == 1) return false;
        else{
            int k = totSum/2;
            int[][] dp = new int[n][k+1];
            for(int i=0;i<n;i++){
                Arrays.fill(dp[i],-1);
            }
            return f(n-1,dp,nums,k);
        }
    }

    public boolean f(int index,int[][] dp,int[] nums,int target){
        if(target == 0) return true;
        if(index == 0) return nums[0] == target;
        if(dp[index][target] != -1) return dp[index][target] == 0 ? false : true;

        boolean notTake = f(index - 1,dp,nums,target);
        boolean take = false;
        if(nums[index] <= target){
            take = f(index - 1,dp,nums,target - nums[index]);
        }

        dp[index][target] = take || notTake ? 1 : 0;
        return take || notTake;
    }
}
