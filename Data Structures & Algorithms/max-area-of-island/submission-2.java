class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] vis = new int[n][m];
        int max = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    max = Math.max(max,bfs(i,j,n,m,vis,grid));
                }
            }
        }
        return max;
    }

    private int bfs(int row,int col,int n,int m,int[][] vis,int[][] grid){
        vis[row][col] = 1;
        Queue<Pair> q = new LinkedList<>();
        int max = 0;
        q.offer(new Pair(row,col));
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            max++;
            q.poll();

            for(int i=0;i<4;i++){
                int nRow = r + delRow[i];
                int nCol = c + delCol[i];

                if(nRow < n && nRow >= 0 && nCol < m && nCol >= 0 && vis[nRow][nCol] == 0 && grid[nRow][nCol] == 1){
                    vis[nRow][nCol] = 1;
                    q.offer(new Pair(nRow,nCol));
                }
            }
        }
            return max;
    }

    class Pair{
        int row;
        int col;

        public Pair(int row,int col){
            this.row = row;
            this.col = col;
        }
    }
}
