class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Double.compare(a.distance,b.distance));
        for(int i=0;i<points.length;i++){
            int x = points[i][0];
            int y = points[i][1];
            double distance = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
            pq.offer(new Pair(x,y,distance));
        }

        int[][] res = new int[k][2];
        int idx = 0;

        for(int i=0;i<k;i++){
            Pair p = pq.poll();
            res[i][0] = p.x;
            res[i][1] = p.y;
        }

        return res;

    }
    class Pair{
        int x;
        int y;
        double distance;

        public Pair(int x,int y,double distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
