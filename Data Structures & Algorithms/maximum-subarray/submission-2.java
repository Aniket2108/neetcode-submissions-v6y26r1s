class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;

        // for(int i=0;i<nums.length;i++){
        //     int sum=0;
        //     for(int j=i;j<nums.length;j++){
        //         sum+=nums[j];
        //         max = Math.max(sum,max);
        //     }
        // }
        // return max;
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            max = Math.max(max,sum);
            if(sum<0){
                sum=0;
            }
        }
        return max;
        // int sum = 0;
        // int maxSum = 0;

        // for(int i=0;i<nums.length;i++){
        //     sum += nums[i];
        //     maxSum = Math.max(sum,maxSum);
        //     if(sum < 0) sum = 0;
        // }
        // return maxSum;
    }
}
