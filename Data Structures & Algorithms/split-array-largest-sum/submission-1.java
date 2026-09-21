class Solution {
    public int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;

        for(int i:nums){
            low = Math.max(low,i);
            high += i;
        }

        while(low <= high){
            int mid = low + (high-low)/2;
            int count = number(nums,mid);
            if(count > k){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return low;
    }

    private int number(int[] nums,int k){
        int count = 1;
        int sum = 0;

        for(int i=0;i<nums.length;i++){
            if(sum + nums[i] <= k){
                sum += nums[i];
            }
            else{
                count++;
                sum = nums[i];
            }
        }
        return count;
    }
}