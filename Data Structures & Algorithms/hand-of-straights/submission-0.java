class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n % groupSize != 0) return false;
        Map<Integer,Integer> map = new TreeMap<>();

        for(int i:hand){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        for(int key:map.keySet()){
            int count = map.get(key);
            if(count > 0){
                for(int i=0;i<groupSize;i++){
                int curr = key + i;
                if(map.getOrDefault(curr,0) < count){
                    return false;
                }
                map.put(curr,map.get(curr) - count);
            }
            }
        }
        return true;
    }
}
