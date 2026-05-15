class Solution {
    public int longestConsecutive(int[] nums) {
        int longest = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            int count = 1;
            int x = nums[i];
            while(linearSearch(nums,x+1)){
                x = x+1;
                count = count + 1;
            }
            longest = Math.max(longest,count);
        }
        return longest == Integer.MIN_VALUE ? 0 : longest;
    }

    public boolean linearSearch(int[] nums,int el){
        for(int i:nums){
            if(i == el) return true;
        }
        return false;
    }
}
