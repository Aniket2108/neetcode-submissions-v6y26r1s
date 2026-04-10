class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Tuple>> adj = new ArrayList<>();
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new Tuple(times[i][1],times[i][2]));
        }

        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b) -> a.time - b.time);
        pq.offer(new Tuple(k,0));
        dist[k] = 0;

        while(!pq.isEmpty()){
            int node = pq.peek().point;
            int time = pq.peek().time;
            pq.poll();
            if(time > dist[node]) continue;

            for(Tuple adjNode:adj.get(node)){
                int point = adjNode.point;
                int edW = adjNode.time;
                if(edW + time < dist[point]){
                    dist[point] = edW + time;
                    pq.offer(new Tuple(point,edW + time));
                }
            }
        }
        int min = Integer.MIN_VALUE;

        for(int i=1;i<dist.length;i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            min = Math.max(min,dist[i]);
        }
        return min;
    }
    public class Tuple{
        int point;
        int time;

        public Tuple(int point,int time){
            this.point = point;
            this.time = time;
        }
    }
}
