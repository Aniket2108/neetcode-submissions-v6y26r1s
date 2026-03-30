class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> b.freq - a.freq);
        Map<Integer,Integer> map = new HashMap<>();

        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            pq.offer(new Node(entry.getKey(),entry.getValue()));
        }

        int res[] = new int[k];
        int index = 0;

        while(k-- > 0){
            res[index++] = pq.poll().num;
        }
        return res;
    }

    public class Node{
        int num;
        int freq;

        public Node(int num,int freq){
            this.num = num;
            this.freq = freq;
        }
    }
}
