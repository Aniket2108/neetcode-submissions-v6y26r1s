class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();

        if(n1 > n2) return false;

        int[] s1C = new int[26];
        int[] s2C = new int[26];

        for(int i=0;i<n1;i++){
            s1C[s1.charAt(i) - 'a']++;
        }

        int l = 0, r = 0;

        while(r < n2){
            s2C[s2.charAt(r) - 'a']++;

            if(r-l+1 > n1){
                s2C[s2.charAt(l) - 'a']--;
                l++;
            }

            if(matches(s1C,s2C)) return true;
            r++;
        }
        return false;
    }

    private boolean matches(int[] s1,int[] s2){
        for(int i=0;i<26;i++){
            if(s1[i]!=s2[i]) return false;
        }
        return true;
    }
}