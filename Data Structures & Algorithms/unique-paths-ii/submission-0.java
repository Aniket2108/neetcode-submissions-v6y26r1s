class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
     int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return f(0,0,m,n,dp,obstacleGrid);
    }

    public int f(int row,int col,int m,int n,int[][] dp,int[][] obstacleGrid){
        if(row >= m || col >= n || obstacleGrid[row][col] == 1) return 0;
        if(row == m-1 && col == n-1) return 1;
        if(dp[row][col] != -1) return dp[row][col];
        int right = f(row+1,col,m,n,dp,obstacleGrid);
        int down = f(row,col+1,m,n,dp,obstacleGrid);
        return dp[row][col] = right + down;
    }
}