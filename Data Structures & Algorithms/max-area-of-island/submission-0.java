class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        int n = grid.length, m = grid[0].length;
        int[][] vis = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    max = Math.max(max,bfs(n,m,i,j,grid,vis));
                }
            }
        }
    return max;
    }

    public int bfs(int n,int m,int r,int c,int[][] grid,int[][] vis){
        vis[r][c] = 1;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(r,c));
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        int area = 0;

        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            area++;
            q.poll();

            for(int i=0;i<4;i++){
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];

                if(nRow < n && nCol < m && nRow >=0 && nCol >= 0 && vis[nRow][nCol] == 0 && grid[nRow][nCol] == 1){
                    q.offer(new Pair(nRow,nCol));
                    vis[nRow][nCol] = 1;
                }
            }
        }
        return area;
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
