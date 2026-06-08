class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] vis = new int[n][m];

        int cnt = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j] == 0 && grid[i][j] == '1'){
                    cnt++;
                    dfs(i,j,n,m,grid,vis);
                }
            }
        }
        return cnt;
    }

    public void dfs(int row,int col,int n,int m,char[][] grid,int[][] vis){
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
                if(nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && vis[nRow][nCol] == 0 && grid[nRow][nCol] == '1'){
                    vis[nRow][nCol] = 1;
                    q.offer(new Pair(nRow,nCol));
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
