class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        int n = s.length();

        for(int i=0;i<n;i++){
            freq[s.charAt(i) - 'a']++;
        }

        int maxFreq = 0, idx = -1;
        for(int i=0;i<26;i++){
            if(freq[i] > maxFreq){
                maxFreq = freq[i];
                idx = i;
            }
        }

        if(maxFreq > (n+1)/2) return "";

        char[] res = new char[n];

        int i = 0;
        while(freq[idx]-- > 0){
            res[i] = (char) (idx + 'a');
            i+=2;
        }

        for(int j=0;j<26;j++){
            while(freq[j]-- > 0){
                if(i >= n) i=1;
                res[i] = (char) (j+'a');
                i+=2;
            }
        }
        return new String(res);
    }
}