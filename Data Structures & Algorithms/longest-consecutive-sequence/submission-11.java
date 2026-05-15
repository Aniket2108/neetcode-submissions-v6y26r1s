class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();

        for(int i:nums){
            set.add(i);
        }

        int longest = Integer.MIN_VALUE;

        for(int it:set){
            if(!set.contains(it-1)){
                int el = it;
                int count = 1;
                while(set.contains(el+1)){
                    el = el + 1;
                    count++;
                }
                longest = Math.max(longest,count);
            }
        }
        return longest == Integer.MIN_VALUE ? 0 : longest;
    }
}
