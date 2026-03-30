class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int el = -1;
        int maxCount = -1;
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(entry.getValue() > maxCount){
                maxCount = entry.getValue();
                el = entry.getKey();
            }
        }
        return el;
    }
}