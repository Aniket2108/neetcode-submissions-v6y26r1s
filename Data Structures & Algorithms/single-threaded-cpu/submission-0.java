class Solution {
    public int[] getOrder(int[][] tasks) {
      int n = tasks.length;
      int[][] task = new int[n][3];

      for(int i=0;i<n;i++){
        task[i][0] = tasks[i][0];
        task[i][1] = tasks[i][1];
        task[i][2] = i;
      }  

      Arrays.sort(task,(a,b) -> a[0]-b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);

        int[] res = new int[n];
        int i=0,idx=0;
        int time = 0;

        while(i < n || !pq.isEmpty()){
            if(pq.isEmpty() && time < task[i][0]){
                time = task[i][0];
            }

            while(i<n && task[i][0]<=time){
                pq.offer(task[i]);
                i++;
            }

            int[] curr = pq.poll();
            time += curr[1];
            res[idx++] = curr[2];
        }
        return res;
    }
}