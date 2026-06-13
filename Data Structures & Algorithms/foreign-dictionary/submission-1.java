class Solution {
    public String foreignDictionary(String[] words) {
      int n = 26;
      List<List<Integer>> adj = new ArrayList<>();

      for(int i=0;i<n;i++){
        adj.add(new ArrayList<>());
      }

      boolean[] present = new boolean[n];

      for(String word:words){
        for(char c:word.toCharArray()){
            present[c - 'a'] = true;
        }
      }

      for(int i=0;i<words.length-1;i++){
        String first = words[i];
        String second = words[i+1];
        int len = Math.min(first.length(),second.length());

        for(int ch=0;ch<len;ch++){
            if(first.length() > second.length() && first.startsWith(second)){
            return "";
            }
            if(first.charAt(ch) != second.charAt(ch)){
                adj.get(first.charAt(ch) - 'a').add(second.charAt(ch) - 'a');
                break;
            }
        }
    }
        List<Integer> topo = topoSort(n,adj);
        StringBuilder sb = new StringBuilder();

        for(int i:topo){
            if(present[i]){
                sb.append((char) (i + 'a'));
            }
        }

        int count = 0;
        for(boolean b:present) if(b) count++;

        if(sb.length() != count) return "";

        return sb.toString();

      }
      private List<Integer> topoSort(int n,List<List<Integer>> adj){

        int[] indegree = new int[n];

        for(int i=0;i<n;i++){
            for(int nei:adj.get(i)){
                indegree[nei]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> topo = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            topo.add(node);
            for(int nei:adj.get(node)){
                indegree[nei]--;
                if(indegree[nei] == 0){
                    q.add(nei);
                }
            }
        }
        return topo;
    }


}
