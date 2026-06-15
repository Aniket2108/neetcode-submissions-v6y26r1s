class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Node>> adj = new ArrayList<>();

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<times.length;i++){
            adj.get(times[i][0]).add(new Node(times[i][1],times[i][2]));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.time - b.time);

        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        pq.offer(new Node(k,0));
        dist[k] = 0;


        while(!pq.isEmpty()){
            int node = pq.peek().point;
            int time = pq.peek().time;
            pq.poll();
            if(time > dist[node]) continue;

            for(Node adjNode:adj.get(node)){
                int point = adjNode.point;
                int edW = adjNode.time;
                if(edW + time < dist[point]){
                    dist[point] = edW + time;
                    pq.offer(new Node(point,edW + time));
                }
            }
        }

        int min = Integer.MIN_VALUE;

        for(int i=1;i<=n;i++){
            if(dist[i] == Integer.MAX_VALUE)
                return -1;

        min = Math.max(min, dist[i]);
    }
    return min;
    }

    public class Node{
        int point;
        int time;

        public Node(int point,int time){
            this.point = point;
            this.time = time;
        }
    }
}
