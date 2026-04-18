class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[] prev = new int[n];
        if (obstacleGrid[0][0] == 1) return 0; 

        for(int i=0;i<m;i++){
            int[] tmp = new int[n];
            for(int j=0;j<n;j++){
                if(i == 0 && j == 0) {
                    tmp[j] = 1;
                    continue;
                }
                if(obstacleGrid[i][j] == 1){
                    tmp[j] = 0;
                    continue;
                }
                int up = 0, left = 0;
                if(i > 0) up = prev[j]; 
                if(j > 0) left = tmp[j-1];
                tmp[j] = up + left;
            }
            prev = tmp;
        }
        return prev[n-1];
    }
}