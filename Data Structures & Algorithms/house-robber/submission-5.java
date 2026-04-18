class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        int prev2 = nums[0];
        int prev = Math.max(nums[0],nums[1]);

        for(int i=2;i<n;i++){
            int notTake = prev;
            int take = nums[i] + prev2;
            int cur = Math.max(take,notTake);
            prev2 = prev;
            prev = cur;
        }
        return prev;
    }
}
