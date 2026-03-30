class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int cnt = 1;
        int lastSmall = Integer.MIN_VALUE;
        int maxCnt = 0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]-1 == lastSmall){
                cnt++;
                lastSmall = nums[i];
            }
            else if (lastSmall != nums[i]){
                cnt = 1;
                lastSmall = nums[i];
            }
                maxCnt = Math.max(maxCnt,cnt);
        }
    return maxCnt;
    }
}
