class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;

        int l = 0, r = 0;
        int[] hash = new int[256];
        Arrays.fill(hash,-1);

        while(r < s.length()){
            char ch = s.charAt(r);
            if(hash[ch] >= l){
                l = hash[ch] + 1;
            }
            maxLen = Math.max(r-l+1,maxLen);
            hash[ch] = r;
            r++;
        }
        return maxLen;
    }
}
