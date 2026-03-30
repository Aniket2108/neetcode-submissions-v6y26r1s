class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen =0 ;

        int[] hash = new int[256];
        Arrays.fill(hash,-1);

        int l = 0, r = 0;

        while(r < s.length()){

            if(hash[s.charAt(r)] >= l){
                l = Math.max(hash[s.charAt(r)]+1,l);
            }
            int len = r-l+1;
            maxLen = Math.max(maxLen,len);
            hash[s.charAt(r)] = r;
            r++;

        }
        return maxLen;
    }
}
