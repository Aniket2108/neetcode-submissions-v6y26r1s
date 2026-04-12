class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {

        boolean[][] reachable = new boolean[n][n];

        // direct edges
        for(int[] p : prerequisites){
            reachable[p[0]][p[1]] = true;
        }

        // Floyd Warshall
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(reachable[i][k] && reachable[k][j]){
                        reachable[i][j] = true;
                    }
                }
            }
        }

        List<Boolean> ans = new ArrayList<>();

        for(int[] q : queries){
            ans.add(reachable[q[0]][q[1]]);
        }

        return ans;
    }
}