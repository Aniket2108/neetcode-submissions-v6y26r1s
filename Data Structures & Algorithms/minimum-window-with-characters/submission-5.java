class Solution {
    public String minWindow(String s, String t) {
        int[] hash = new int[256];

        for(int i=0;i<t.length();i++){
            hash[t.charAt(i)]++;
        }

        int sIndex = -1;
        int minLen = Integer.MAX_VALUE;
        int count = 0;

        int l=0, r=0;

        while(r < s.length()){
            if(hash[s.charAt(r)] > 0){
                count++;
            }
            hash[s.charAt(r)]--;
            while(count == t.length()){
                if(r-l+1 < minLen){
                    minLen = r-l+1;
                    sIndex = l;
                }
                hash[s.charAt(l)]++;
                if(hash[s.charAt(l)] > 0) count--;
                l++;
        }
            r++;
    }
        return sIndex == -1 ? "" : s.substring(sIndex,sIndex+minLen);
}
}
