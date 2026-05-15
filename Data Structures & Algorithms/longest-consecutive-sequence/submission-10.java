class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int longest = 1;
        int lastSmaller = nums[0];
        int count = 1;

        for(int i=1;i<nums.length;i++){
            if(nums[i] == lastSmaller) continue;

            if(nums[i] - 1 == lastSmaller){
                count++;
            }
            else{
                count = 1;
            }
            lastSmaller = nums[i];
            longest = Math.max(longest,count);
        }
        return longest;
    }
}
