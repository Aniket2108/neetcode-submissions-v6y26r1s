class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        int n = queries.length;

        int[][] sortedQueries = new int[n][2];

        for(int i=0;i<n;i++){
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries,(a,b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);

        int i=0;

        int[] ans = new int[n];

        for(int[] query:sortedQueries){
            int q = query[0];

            while(i < intervals.length && intervals[i][0] <= q){
                int length = intervals[i][1] - intervals[i][0] + 1;

                pq.offer(new int[]{length,intervals[i][1]});
                i++;
            }

            while(!pq.isEmpty() && pq.peek()[1] < q){
                pq.poll();
            }

            ans[query[1]] = pq.isEmpty() ? -1 : pq.peek()[0];
        }
        return ans;
    }
}
