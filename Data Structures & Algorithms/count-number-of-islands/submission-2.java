class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] vis = new int[n][m];
        int cnt = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j] == 0 && grid[i][j] == '1'){
                    cnt++;
                    bfs(i,j,vis,grid,n,m);
                }
            }
        }
        return cnt;
    }

    private void bfs(int row,int col,int[][] vis,char[][] grid,int n,int m){
        vis[row][col] = 1;
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(row,col));

        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            q.poll();

            for(int i=0;i<4;i++){
                int nRow = r + delRow[i];
                int nCol = c + delCol[i];

                if(nRow < n && nRow >= 0 && nCol < m && nCol >= 0 && vis[nRow][nCol] == 0 && grid[nRow][nCol] == '1'){
                    bfs(nRow,nCol,vis,grid,n,m);
                }
            }
        }
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
