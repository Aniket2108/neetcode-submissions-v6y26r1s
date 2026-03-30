class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;

        char[] s1C = s1.toCharArray();
        Arrays.sort(s1C);

        for(int i=0;i<=s2.length()-s1.length();i++){
            char[] tmp = s2.substring(i,i+s1.length()).toCharArray();
            Arrays.sort(tmp);

            if(Arrays.equals(s1C,tmp)) return true;
        }
        return false;
    }
}