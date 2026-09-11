class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0;
        int[] hash = new int[26];
        int maxLen = 0;
        int maxFreq = 0;

        while(r < s.length()){
            hash[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq,hash[s.charAt(r) - 'A']);

            if((r-l+1)-maxFreq > k){
                hash[s.charAt(l) - 'A']--;
                l++;
            }
            maxLen = Math.max(maxLen,r-l+1);
            r++;
        }
    return maxLen;
    }
}
