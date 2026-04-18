class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];        

        return Math.max(rob2(nums,0,n-2),rob2(nums,1,n-1));
    }

    public int rob2(int[] nums,int start,int end) {
        int prev2 = 0;
        int prev = 0;

        for(int i=start;i<=end;i++){
            int notTake = prev;
            int take = nums[i] + prev2;
            int cur = Math.max(take,notTake);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
}
