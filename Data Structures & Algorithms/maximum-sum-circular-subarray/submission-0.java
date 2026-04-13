class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int globalMax = nums[0], globalMin = nums[0];
        int min = 0, max = 0;
        int total = 0;

        for(int i:nums){
            max = Math.max(max + i, i);
            min = Math.min(min + i, i);
            total += i;
            globalMax = Math.max(max,globalMax);
            globalMin = Math.min(min,globalMin);
        }

        return globalMax > 0 ? Math.max(globalMax,total - globalMin) : globalMax;
    }
}