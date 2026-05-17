class Solution {
    public int characterReplacement(String s, int k) {
       int maxLen = 0;

       for(int i=0;i<s.length();i++){
        int[] hash = new int[26];
        int freq = 0;
        for(int j=i;j<s.length();j++){
            hash[s.charAt(j) - 'A']++;
            freq = Math.max(freq,hash[s.charAt(j) - 'A']);
            int changes = (j-i+1) - freq;
            if(changes <= k){
                maxLen = Math.max(j-i+1,maxLen);
            }
            else{
                break;
            }
        }
       } 
       return maxLen;
    }
}
