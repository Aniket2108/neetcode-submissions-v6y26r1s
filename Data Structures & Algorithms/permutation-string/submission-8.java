class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();

        if(n1 > n2) return false;

        int[] s1C = new int[26];
        int[] s2C = new int[26];

        for(int i=0;i<n1;i++){
            s1C[s1.charAt(i) - 'a']++;
            s2C[s2.charAt(i) - 'a']++;
        }

        int matches = 0;

        for(int i=0;i<26;i++){
            if(s1C[i] == s2C[i]){
                matches++;
            }
        }

        int l = 0;

        for(int r=n1;r<n2;r++){
            if(matches == 26){
                return true;
            }

            int idx = s2.charAt(r) - 'a';
            s2C[idx]++;

            if(s1C[idx] == s2C[idx]) matches++;
            else if(s1C[idx] +1 == s2C[idx]) matches--;

            int leftIdx = s2.charAt(l) - 'a';
            s2C[leftIdx]--;

            if(s1C[leftIdx] == s2C[leftIdx]) matches++;
            else if(s1C[leftIdx]-1 == s2C[leftIdx]) matches--;

            l++;
        }

        return matches == 26;
    }
}