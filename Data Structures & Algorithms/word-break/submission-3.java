class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Boolean[][] dp = new Boolean[s.length()][s.length()];
        return wordBreak(0,0,s,set,dp);
    }

    public boolean wordBreak(int start,int end,String s,Set<String> set,Boolean[][] dp){
        if(dp[start][end] != null) return dp[start][end];
        if(end == s.length()-1){
            if(set.contains(s.substring(start,end+1))) {
                return dp[start][end] = true;
            }
            return dp[start][end] = false;
        }

        if(set.contains(s.substring(start,end+1))){
            if(wordBreak(end+1,end+1,s,set,dp)){
                return dp[start][end] = true;
            }
        }

        return dp[start][end] = wordBreak(start,end+1,s,set,dp);
    }
}
