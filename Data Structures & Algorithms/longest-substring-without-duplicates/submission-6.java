class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen =0 ;

        for(int i=0;i<s.length();i++){
            char[] ch = new char[256];
            for(int j=i;j<s.length();j++){
                if(ch[s.charAt(j)] == 1) break;
                maxLen = Math.max(j-i+1,maxLen);
                ch[s.charAt(j)] = 1;
            }
        }
        return maxLen;
    }
}
