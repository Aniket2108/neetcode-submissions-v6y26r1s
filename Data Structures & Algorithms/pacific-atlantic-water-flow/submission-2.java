class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        for(int i=0;i<n;i++){
            dfs(i,0,n,m,pacific,heights);
            dfs(i,m-1,n,m,atlantic,heights);
        }

        for(int j=0;j<m;j++){
            dfs(0,j,n,m,pacific,heights);
            dfs(n-1,j,n,m,atlantic,heights);
        }

        List<List<Integer>> res = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }

    private void dfs(int row,int col,int n,int m,boolean[][] vis,int[][] heights){
        vis[row][col] = true;
        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        for(int i=0;i<4;i++){
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if(nRow < n && nCol < m && nRow >= 0 && nCol >= 0 && !vis[nRow][nCol] && heights[nRow][nCol] >= heights[row][col]){
                dfs(nRow,nCol,n,m,vis,heights);
            }
        }
    }
}
