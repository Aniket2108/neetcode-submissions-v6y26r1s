class Solution {
    public boolean isAnagram(String s, String t) {
        int[] ch = new int[26];
        if (s.length() != t.length()) {
            return false;
        }
        for(char c:s.toCharArray()){
            ch[c - 'a']++;
        }
        for(char c:t.toCharArray()){
            ch[c - 'a']--;
        }
        for(int i=0;i<ch.length;i++){
            if(ch[i] != 0){
                return false;
            }
        }
        return true;
    }
}
