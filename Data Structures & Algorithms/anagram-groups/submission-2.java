class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String s:strs){
            int[] ch = new int[26];
            for(char c:s.toCharArray()){
                ch[c - 'a']++;
            }

            StringBuilder key = new StringBuilder();
            for(int i:ch){
                key.append(i).append('#');
            }

            map.putIfAbsent(key.toString(),new ArrayList<>());
            map.get(key.toString()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
