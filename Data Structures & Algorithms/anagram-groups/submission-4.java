class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String str:strs){
            int[] hash = new int[26];

            for(int i=0;i<str.length();i++){
                hash[str.charAt(i) - 'a']++;
            }

            StringBuilder key = new StringBuilder();

            for(int i=0;i<26;i++){
                key.append(hash[i]).append('#');
            } 

            map.putIfAbsent(key.toString(),new ArrayList<>());
            map.get(key.toString()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
