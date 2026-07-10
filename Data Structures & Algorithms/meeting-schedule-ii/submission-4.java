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
        intervals.sort((a,b) -> a.start - b.start);
        PriorityQueue<Interval> pq = new PriorityQueue<>((a,b) -> a.end-b.end);
        if(intervals.size() == 0) return 0;
        pq.offer(intervals.get(0));

        for(int i=1;i<intervals.size();i++){
            if(pq.peek().end <= intervals.get(i).start){
                pq.poll();
            }
            pq.offer(intervals.get(i));
        }

        return pq.size();
    }
}
