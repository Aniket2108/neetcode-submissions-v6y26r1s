class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        int[][] dist = new int[n][m];
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b) -> a.distance - b.distance);
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        pq.offer(new Tuple(0,0,0));
        dist[0][0] = 0;
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};


        while(!pq.isEmpty()){
            int row = pq.peek().row;
            int col = pq.peek().col;
            int diff = pq.peek().distance;
            pq.poll();

        if(row == n-1 && col == m-1) return diff;
            for(int i=0;i<4;i++){
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];

                if(nRow < n && nCol < m && nRow >= 0 && nCol >= 0){
                int newDiff = Math.max(Math.abs(heights[row][col] - heights[nRow][nCol]),diff);
                    if(newDiff < dist[nRow][nCol]){
                        dist[nRow][nCol] = newDiff;
                        pq.offer(new Tuple(nRow,nCol,newDiff));
                    }
                }
            }
        }
        return 0;
    }

    public class Tuple{
        int row;
        int col;
        int distance;

        public Tuple(int row,int col,int distance){
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }
}