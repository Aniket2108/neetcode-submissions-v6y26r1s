class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }

        Arrays.sort(strs);
        int i=0;

        while(i<strs[0].length() && i<strs[strs.length-1].length() && strs[0].charAt(i) == strs[strs.length-1].charAt(i)){
            i++;
        }

        return strs[0].substring(0,i);


    }
}