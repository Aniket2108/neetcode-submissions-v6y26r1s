class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;

        for(int i = 0; i<s.length();i++){
            char[] hash = new char[256];
            for(int j=i;j<s.length();j++){
                if(hash[s.charAt(j)] == 1) break;
                maxLen = Math.max(maxLen,j-i+1);
                hash[s.charAt(j)] = 1;
            }
        }
        return maxLen;
    }
}
