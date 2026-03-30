class Solution {
    public int subarraySum(int[] nums, int k) {
        int cnt = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int prefixSum = 0;

        for(int i=0;i<nums.length;i++){
            prefixSum += nums[i];
            int remove = prefixSum - k;

            if(map.containsKey(remove)){
                cnt += map.get(remove);
            }
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        return cnt;
    }
}