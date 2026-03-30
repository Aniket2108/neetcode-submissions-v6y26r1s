class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen = 0;

        for(int i=0;i<s.length();i++){
            int[] hash = new int[26];
            int len = 0;
            for(int j=i;j<s.length();j++){
                hash[s.charAt(j) - 'A']++;
                len = Math.max(len,hash[s.charAt(j) - 'A']);
                int changes = (j-i+1) - len;
                if(changes <= k){
                    maxLen = Math.max(maxLen,j-i+1);
                }
                else{
                    break;
                }
            }
        }
        return maxLen;
    }
}
