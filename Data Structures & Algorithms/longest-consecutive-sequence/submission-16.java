class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i:nums){
            set.add(i);
        }

        int maxCount = 0;

        for(int i=0;i<nums.length;i++){
            if(!set.contains(nums[i]-1)){
                int count = 1;
                int el = nums[i];
                while(set.contains(el + 1)){
                    count++;
                    el = el+1;
                }
                maxCount = Math.max(count,maxCount);
            }
        }
        return maxCount;
    }
}
