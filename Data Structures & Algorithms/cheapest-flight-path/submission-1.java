class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Node>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new Node(flights[i][1],flights[i][2]));
        }


        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(src,0,0));

        while(!q.isEmpty()){
            int node = q.peek().node;
            int steps = q.peek().steps;
            int weight = q.peek().weight;
            q.poll();
            if(steps > k) continue;

            for(Node adjNode:adj.get(node)){
                if(adjNode.weight + weight < dist[adjNode.point]){
                    dist[adjNode.point] = adjNode.weight + weight;
                    q.offer(new Tuple(adjNode.point,steps+1,adjNode.weight + weight));
                }
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    public class Tuple{
        int node;
        int steps;
        int weight;

        public Tuple(int node,int steps,int weight){
            this.node = node;
            this.steps = steps;
            this.weight = weight;
        }
    }

    public class Node{
        int point;
        int weight;

        public Node(int point,int weight){
            this.point = point;
            this.weight = weight;
        }
    }
}
