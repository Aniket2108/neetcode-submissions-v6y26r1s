class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,((a,b) -> a[0] - b[0]));
        
        List<int[]> res = new ArrayList<>();

        for(int i=0;i<intervals.length;i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
                if(!res.isEmpty() && res.get(res.size()-1)[1] >= end){
                    continue;
                }
            for(int j=i+1;j<intervals.length;j++){
                if(end >= intervals[j][0]){
                    end = Math.max(end,intervals[j][1]);
                }
                else{
                    break;
                }
            }
                res.add(new int[]{start,end});
        }

        return res.toArray(new int[res.size()][]);
    }
}
