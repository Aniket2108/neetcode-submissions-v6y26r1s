class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        if(nums.length == 0) return 0;
        for(int i:nums){
            set.add(i);
        }

        int maxLen = Integer.MIN_VALUE;

        for(int i:set){
            if(!set.contains(i-1)){
                int count = 1;
                int el = i;
                while(set.contains(el + 1)){
                    count++;
                    el = el+1;
                }
                maxLen = Math.max(maxLen,count);
            }
        }
        return maxLen;
    }
}
