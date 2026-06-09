class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] vis = new int[n][m];
        Queue<Tuple> q = new LinkedList<>();
        int cntFresh = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    cntFresh++;
                }
                else if(grid[i][j] == 2){
                    q.offer(new Tuple(i,j,0));
                    vis[i][j] = 1;
                }
            }
        }

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        int time = 0;

        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int tm = q.peek().time;
            time = Math.max(time,q.peek().time);
            q.poll();

            for(int i=0;i<4;i++){
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];

                if(nRow < n && nRow >= 0 && nCol < m && nCol >= 0 && vis[nRow][nCol] == 0 && grid[nRow][nCol] == 1){
                    cntFresh--;
                    vis[nRow][nCol] = 1;
                    q.offer(new Tuple(nRow,nCol,tm+1));
                }
            }
        }
        return cntFresh == 0 ? time : -1;
    }

    class Tuple{
        int row;
        int col;
        int time;

        public Tuple(int row,int col,int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
}
