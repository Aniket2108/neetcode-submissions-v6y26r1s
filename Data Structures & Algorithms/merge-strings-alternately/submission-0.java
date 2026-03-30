class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i=0,j=0;
        String str = "";
        while(i<word1.length() && j<word2.length()){
            str += word1.charAt(i);
            str += word2.charAt(j);
            i++;j++;
        }

        while(i<word1.length()){
            str += word1.charAt(i);
            i++;
        }

        while(j<word2.length()){
            str += word2.charAt(j);
            j++;
        }
    return str;
    }
}