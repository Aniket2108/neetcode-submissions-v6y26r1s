class Solution {
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        int[][] vis = new int[n][m];
        int[] dRow = {-1,0,1,0};
        int[] dCol = {0,1,0,-1};

        for(int j=0;j<m;j++){
            if(vis[0][j] == 0 && board[0][j] == 'O'){
                dfs(0,j,vis,board,dRow,dCol);
            }
            if(vis[n-1][j] == 0 && board[n-1][j] == 'O'){
                dfs(n-1,j,vis,board,dRow,dCol);
            }
        }

        for(int i=0;i<n;i++){
            if(vis[i][0] == 0 && board[i][0] == 'O'){
                dfs(i,0,vis,board,dRow,dCol);
            }
            if(vis[i][m-1] == 0 && board[i][m-1] == 'O'){
                dfs(i,m-1,vis,board,dRow,dCol);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(int row,int col,int[][] vis,char[][] board,int[] dRow,int[] dCol){
        int n = board.length, m = board[0].length;
        vis[row][col] = 1;
        for(int i=0;i<4;i++){
            int nRow = row + dRow[i];
            int nCol = col + dCol[i];

            if(nRow < n && nCol < m && nRow >= 0 && nCol >= 0 && vis[nRow][nCol] == 0 && board[nRow][nCol] == 'O'){
                dfs(nRow,nCol,vis,board,dRow,dCol);
            }
        }
    }
}