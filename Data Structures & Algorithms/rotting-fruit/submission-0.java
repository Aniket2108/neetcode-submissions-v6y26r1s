class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int n = grid.length, m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 2){
                    q.offer(new Pair(i,j,0));
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        int tm = 0;

        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tm;
            tm = Math.max(t,tm);
            q.poll();

            for(int i=0;i<4;i++){
                int nRow = r + drow[i];
                int nCol = c + dcol[i];

                if(nRow < n && nCol < m && nRow >= 0 && nCol >= 0 && grid[nRow][nCol] == 1){
                    q.offer(new Pair(nRow,nCol,t+1));
                    grid[nRow][nCol] = 2;
                    fresh--;
                }
            }
        }
        return fresh == 0 ? tm : -1;
    }

    class Pair{
        int row;
        int col;
        int tm;

        public Pair(int row,int col,int tm){
            this.row = row;
            this.col = col;
            this.tm = tm;
        }
    }
}