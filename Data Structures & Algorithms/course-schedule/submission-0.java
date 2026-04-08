class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for(int i=0;i<numCourses;i++){
            for(int it:list.get(i)){
                indegree[it]++;
            }
        }

        for(int i=0;i<indegree.length;i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int cnt = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            cnt++;
            for(int adj:list.get(node)){
                indegree[adj]--;
                if(indegree[adj] == 0){
                    q.offer(adj);
                }
            }
        }
        return cnt == numCourses ? true : false;
    }
}