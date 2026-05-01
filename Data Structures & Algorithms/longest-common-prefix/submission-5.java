class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int i=0;

        while(i<strs[0].length() && i <strs[strs.length-1].length() && strs[0].charAt(i) == strs[strs.length-1].charAt(i)){
            i++;
        }

        return strs[strs.length-1].substring(0,i);
    }
}