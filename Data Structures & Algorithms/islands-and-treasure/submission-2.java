class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] vis = new int[n][m];
        Queue<Tuple> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 0){
                    q.offer(new Tuple(i,j,0));
                }
            }
        }

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int dist = q.peek().dist;
            q.poll();

            for(int i=0;i<4;i++){
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];

                if(nRow < n && nRow >= 0 && nCol < m && nCol >= 0 && vis[nRow][nCol] == 0 && grid[nRow][nCol] == 2147483647){
                    vis[nRow][nCol] = 1;
                    grid[nRow][nCol] = dist + 1;
                    q.offer(new Tuple(nRow,nCol,dist+1));
                }
            }
        }

    }

    class Tuple{
        int row;
        int col;
        int dist;

        public Tuple(int row,int col,int dist){
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
}
