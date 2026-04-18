class Solution {
    public int minPathSum(int[][] grid) {
       int m = grid.length, n = grid[0].length;
       int[][] dp = new int[m][n];

       for(int i=0;i<m;i++){
        Arrays.fill(dp[i],-1);
       }

       return f(m-1,n-1,m,n,grid,dp);
    }

    public int f(int row,int col,int m,int n,int[][] grid,int[][] dp){
        if(row < 0 || col < 0) return (int)1e9;
        if(row == 0 && col == 0) return grid[0][0];
        if(dp[row][col] != -1) return dp[row][col];

        int left = grid[row][col] + f(row,col-1,m,n,grid,dp);
        int up = grid[row][col] + f(row-1,col,m,n,grid,dp);

        return dp[row][col] = Math.min(left,up);
    }
}