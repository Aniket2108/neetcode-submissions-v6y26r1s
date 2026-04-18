class Solution {
    public int minPathSum(int[][] grid) {
       int m = grid.length, n = grid[0].length;
       int[] prev = new int[n];


       for(int i=0;i<m;i++){
        int[] tmp = new int[n];
        for(int j=0;j<n;j++){
            if(i == 0 && j == 0){
                tmp[j] = grid[0][0];
                continue;
            }
            int up = Integer.MAX_VALUE, left = Integer.MAX_VALUE;
            if(i > 0) up = grid[i][j] + prev[j];
            if(j > 0) left = grid[i][j] + tmp[j-1];
            tmp[j] = Math.min(up,left);
        }
        prev = tmp;
       }

       return prev[n-1];
    }

}