/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        ListNode res = new ListNode(-1);
        ListNode dummy = res;

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val -b.val);

        for(ListNode node:lists){
            if(node != null)
            pq.offer(node);
        }

        while(!pq.isEmpty()){
            ListNode min = pq.poll();
            dummy.next = min;
            dummy = dummy.next;
            if(min.next != null){
                pq.offer(min.next);
            }
        }

        return res.next;
    }
}
