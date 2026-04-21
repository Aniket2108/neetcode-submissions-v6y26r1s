class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[] prev = new int[m+1];

        prev[0] = 1;
            
        

        for(int i=1;i<=n;i++){
        int[] cur = new int[m+1];
        cur[0] = 1;
            for(int j=1;j<=m;j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
             cur[j] = prev[j-1] + prev[j];
        }
        else{
             cur[j] = prev[j];
        }
            }
            prev = cur;
        }

        return prev[m];
    }
}
