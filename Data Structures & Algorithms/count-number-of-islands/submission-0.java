class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length,m=grid[0].length;
        int cnt = 0;
        int[][] vis = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j] == 0 && grid[i][j] == '1'){
                    cnt++;
                    bfs(i,j,n,m,vis,grid);
                }
            }
        }
        return cnt;
    }

    public void bfs(int r,int c,int n,int m,int[][] vis,char[][] grid){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(r,c));
        vis[r][c] = 1;
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            q.poll();

            for(int i=0;i<4;i++){
                    int nRow = row + delRow[i];
                    int nCol = col + delCol[i];

                    if(nRow < n && nCol < m && nRow >= 0 && nCol >= 0 && vis[nRow][nCol] == 0 && grid[nRow][nCol] == '1'){
                        vis[nRow][nCol] = 1;
                        q.offer(new Pair(nRow,nCol));
                    }
            }
            
        }
    }

    public class Pair{
        int row;
        int col;
    public Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
    }
}
