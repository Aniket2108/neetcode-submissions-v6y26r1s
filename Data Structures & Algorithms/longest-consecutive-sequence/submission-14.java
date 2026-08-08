class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int maxLen = 0;
        int count = 0;
        int lastSmaller = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            if(nums[i]-1 == lastSmaller){
                count++;
                lastSmaller = nums[i];
            }
            else if(nums[i] != lastSmaller){
                count = 1;
                lastSmaller = nums[i];
            }
            maxLen = Math.max(maxLen,count);
        }
        return maxLen;
    }
}
