class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n+1][m+1];

        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }

        return minDistance(n,m,word1,word2,dp);
    }

    public int minDistance(int i,int j,String word1,String word2,int[][] dp){
        if(i == 0) return j;
        if(j == 0) return i;
        if(dp[i][j] != -1) return dp[i][j];

        if(word1.charAt(i-1) == word2.charAt(j-1)){
            return dp[i][j] = minDistance(i-1,j-1,word1,word2,dp);
        }
        return dp[i][j] =Math.min(1+minDistance(i-1,j,word1,word2,dp),Math.min(1+minDistance(i-1,j-1,word1,word2,dp),1+minDistance(i,j-1,word1,word2,dp)));
    }
}
