class Solution {
    public int majorityElement(int[] nums) {
        int max = -1;
        int maxCount = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            int count = 0;
            for(int j=0;j<nums.length;j++){
                if(nums[i] == nums[j]){
                    count++;
                }
            }
            if(count > maxCount){
                maxCount = count;
                max = nums[i];
            }
        }
        return max;
    }
}