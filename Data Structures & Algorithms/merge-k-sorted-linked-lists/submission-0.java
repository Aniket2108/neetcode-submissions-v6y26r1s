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
        if(lists.length == 0 || lists == null) return null;
        ListNode head = lists[0];

        for(int i=1;i<lists.length;i++){
                head = mergeTwoLists(head,lists[i]);
        }
        return head;
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newNode = new ListNode(-1);

        ListNode dummy = newNode;

        while(list1!=null && list2!=null){
            if(list1.val <= list2.val){
                dummy.next = list1;
                list1 = list1.next;
            }
            else{
                dummy.next = list2;
                list2 = list2.next;
            }
            dummy = dummy.next;
        }

        if(list1 != null) dummy.next = list1;
        if(list2 != null) dummy.next = list2;

        return newNode.next;
    }
}
