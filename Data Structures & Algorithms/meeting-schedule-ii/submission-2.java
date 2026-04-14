/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.size() == 0) return 0;
        
        int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];
        int rooms = 0, i = 0, j = 0;
        int max = Integer.MIN_VALUE;

        for(int k=0;k<intervals.size();k++){
            start[k] = intervals.get(k).start;
            end[k] = intervals.get(k).end;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        while(i<start.length){
            if(start[i] < end[j]){
                rooms++;
                i++;
            }
            else{
                rooms--;
                j++;
            }
            max = Math.max(rooms,max);
        }
        return max;
    }
}
