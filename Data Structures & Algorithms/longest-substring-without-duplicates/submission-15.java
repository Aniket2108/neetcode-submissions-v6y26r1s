class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0,left = 0;
        int[] hash = new int[256];

        Arrays.fill(hash,-1);

        for(int right = 0;right<s.length();right++){
            char ch = s.charAt(right);

            if(hash[ch] >= left){
                left = hash[ch] + 1;
            }

            hash[ch] = right;
            ans = Math.max(ans,right - left + 1);
        }   
        return ans;
    }
}
