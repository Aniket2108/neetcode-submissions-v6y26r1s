class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] vis = new int[n][m];
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist);
        pq.offer(new Node(0,0,grid[0][0]));
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        int ans = 0;

        while(!pq.isEmpty()){
            int row = pq.peek().row;
            int col = pq.peek().col;
            int dist = pq.peek().dist;
            pq.poll();
            if(vis[row][col] == 1) continue;
            vis[row][col] = 1;
            ans = Math.max(ans,grid[row][col]);
            if(row == n-1 && col == n-1) return ans;

            for(int i=0;i<4;i++){
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];

                if(nRow < n && nCol < m && nRow >=0 && nCol >=0 && vis[nRow][nCol] == 0){
                    pq.offer(new Node(nRow,nCol,grid[nRow][nCol]));
                }
            }
        }
        return -1;
    }

    public class Node{
        int row;
        int col;
        int dist;

        public Node(int row,int col,int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
}
