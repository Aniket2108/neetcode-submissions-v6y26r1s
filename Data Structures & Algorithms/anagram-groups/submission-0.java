class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();

        for(int i=0;i<strs.length;i++){
            List<String> tmp = new ArrayList<>();
            for(int j=0;j<strs.length;j++){
                if(isAnagram(strs[i],strs[j])){
                    tmp.add(strs[j]);
                }
            }
            tmp.sort(null);
            if(!ans.contains(tmp)){
                ans.add(tmp);
            }

        }
        return ans;
    }

    public boolean isAnagram(String s, String t) {
        int[] ch = new int[26];
        if (s.length() != t.length()) {
            return false;
        }
        for(int i=0;i<t.length();i++){
            ch[s.charAt(i) - 'a']++;
            ch[t.charAt(i) - 'a']--;
        }
        for(int i=0;i<ch.length;i++){
            if(ch[i] != 0){
                return false;
            }
        }
        return true;
    }
}
