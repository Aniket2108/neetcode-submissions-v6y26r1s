class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        
        for(int i=0;i<intervals.length;i++){
            if(res.isEmpty() || res.getLast()[1] < intervals[i][0]){
                res.add(intervals[i]);
            }
            else{
                res.getLast()[1] = Math.max(res.getLast()[1],intervals[i][1]);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
