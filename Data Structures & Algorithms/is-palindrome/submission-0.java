class Solution {
    public boolean isPalindrome(String s) {
        String str = "";
        String og = "";

        for(char c : s.toCharArray()){
            if((c >= 'a' && c<= 'z') || (c >= 'A' && c <= 'Z') || (c>= '0' && c <= '9')){
                str = c + str;
                og += c;
            }
        }

        return str.equalsIgnoreCase(og);
    }
}
