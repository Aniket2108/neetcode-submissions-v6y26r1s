class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(int i=0;i<strs.length;i++){
            String str = strs[i];

            int[] hash = new int[26];

            for(int j=0;j<str.length();j++){
                hash[str.charAt(j) - 'a']++;
            }

            StringBuilder sb = new StringBuilder();

            for(int j=0;j<26;j++){
                sb.append(hash[j]).append('#');
            }

            map.putIfAbsent(sb.toString(),new ArrayList<>());
            map.get(sb.toString()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
