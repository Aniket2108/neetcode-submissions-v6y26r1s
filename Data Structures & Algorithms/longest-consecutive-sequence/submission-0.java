class Solution {
    public int longestConsecutive(int[] nums) {
        
        int maxCount = 0;

        for(int i=0;i<nums.length;i++){
            int el = nums[i];
            int count = 1;
            while(true){
                if(linearSearch(nums,el+1)){
                    el = el+1;
                    count++;
                }
                else{
                    maxCount = Math.max(count,maxCount);
                    break;
                }
            }
        }
        return maxCount;
    }

    public boolean linearSearch(int[] nums,int element){
        for(int i:nums){
            if(i==element){
                return true;
            }
        }
        return false;
    }
}
