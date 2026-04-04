class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(0,0,nums.length,nums);
    }

    public int dfs(int i,int total,int n,int[] nums){
        if(i==n) return total;

        return dfs(i+1,total ^ nums[i],n,nums) + dfs(i+1,total,n,nums);
    }
}