class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int i:stones){
            pq.offer(i);
        }

        while(pq.size()>1){
            int x = pq.poll();
            int y = pq.poll();
            if(x!=y){
                pq.offer(x-y);
            }
        }
        return pq.size() == 0 ? 0 : pq.poll();
    }
}
