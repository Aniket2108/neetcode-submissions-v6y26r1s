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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null) return head;
        ListNode prev = null;
        ListNode tmp = head;

        while(tmp != null){
            ListNode kth = findKthNode(tmp,k);
            
            if(kth == null){
                if(prev != null){
                    prev.next = tmp;
                }
                break;
            }
            
            ListNode kthNext = kth.next;
            kth.next = null;
            reverse(tmp);

            if(prev == null){
                head = kth;
            }
            else{
                prev.next = kth;
            }

            prev = tmp;
            tmp = kthNext;
        }

        return head;

    }

    private ListNode findKthNode(ListNode head,int k){
        while(head != null && --k>0){
            head = head.next;
        }
        return head;
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;

        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
