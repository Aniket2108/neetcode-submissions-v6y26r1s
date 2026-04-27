class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        Integer[][] dp = new Integer[n][m];
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};
        int max = 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                max = Math.max(max,longestIncreasingPath(i,j,matrix,dp,delRow,delCol));
            }
        }

        return max;
    }

    public int longestIncreasingPath(int i,int j,int[][] matrix,Integer[][] dp,int[] delRow,int[] delCol){
        if(dp[i][j] != null) return dp[i][j];

        int max = 1;

        for(int k=0;k<4;k++){
            int nRow = i + delRow[k];
            int nCol = j + delCol[k];

            if(nRow >= 0 && nCol >= 0 && nRow < matrix.length && nCol < matrix[0].length && matrix[nRow][nCol] > matrix[i][j]){
                max = Math.max(max,1 + longestIncreasingPath(nRow,nCol,matrix,dp,delRow,delCol));
            }
        }
        
        
        return dp[i][j] = max;
    }
}
