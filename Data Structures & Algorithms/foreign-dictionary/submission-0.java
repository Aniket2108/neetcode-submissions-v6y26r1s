class Solution {
    public String foreignDictionary(String[] words) {
        int n = 26;
      List<List<Integer>> adj = new ArrayList<>();

      for(int i=0;i<n;i++){
        adj.add(new ArrayList<>());
      }

    boolean[] present = new boolean[26];

        for(String word : words){
            for(char c : word.toCharArray()){
                present[c - 'a'] = true;
            }
        }

      for(int i=0;i<words.length-1;i++){
        String word1 = words[i];
        String word2 = words[i+1];
        int len = Math.min(word1.length(),word2.length());

        for(int ch=0;ch<len;ch++){
            if(word1.length() > word2.length() && word1.startsWith(word2)){
                return "";
            }
            if(word1.charAt(ch) != word2.charAt(ch)){
                adj.get(word1.charAt(ch) - 'a').add(word2.charAt(ch) - 'a');
                break;
            }
        }
      }
        List<Integer> topo = topoSort(n,adj);
        StringBuilder ans = new StringBuilder();

        for(int i : topo){
            if(present[i]) {
                ans.append((char)(i + 'a'));
            }
        }
        int count = 0;
        for(boolean b : present) if(b) count++;


        if(ans.length() != count) return "";

        return ans.toString();
    }

    public List<Integer> topoSort(int n,List<List<Integer>> adj){
        int[] indegree = new int[n];

        for(int i=0;i<n;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<indegree.length;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        List<Integer> list = new ArrayList<>();

        while(!q.isEmpty()){
            int node = q.poll();
            list.add(node);
            for(int adjNode:adj.get(node)){
                indegree[adjNode]--;
                if(indegree[adjNode] == 0){
                    q.offer(adjNode);
                }
            }
        }
        return list;
    }

}
