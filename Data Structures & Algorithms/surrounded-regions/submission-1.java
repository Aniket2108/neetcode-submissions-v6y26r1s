class Solution {
    public void solve(char[][] board) {
       int n = board.length, m = board[0].length; 
       int[][] vis = new int[n][m];

       for(int i=0;i<n;i++){
        if(vis[i][0] == 0 && board[i][0] == 'O'){
            dfs(i,0,n,m,vis,board);
        }
        if(vis[i][m-1] == 0 && board[i][m-1] == 'O'){
            dfs(i,m-1,n,m,vis,board);
        }
       }

       for(int j=0;j<m;j++){
        if(vis[0][j] == 0 && board[0][j] == 'O'){
            dfs(0,j,n,m,vis,board);
        }
        if(vis[n-1][j] == 0 && board[n-1][j] == 'O'){
            dfs(n-1,j,n,m,vis,board);
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

    public void dfs(int row,int col,int n,int m,int[][] vis,char[][] board){
        vis[row][col] = 1;
        int delRow[] = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        for(int i=0;i<4;i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if(nRow < n && nRow >= 0 && nCol < m && nCol >= 0 && vis[nRow][nCol] == 0 && board[nRow][nCol] == 'O'){
                dfs(nRow,nCol,n,m,vis,board);
            }
        }
    }
}
