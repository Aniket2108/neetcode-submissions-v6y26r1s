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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode newNode = new ListNode(-1);

        ListNode tmp1 = list1, tmp2 = list2, dummy = newNode;

        while(tmp1!=null && tmp2!=null){
            if(tmp1.val > tmp2.val){
                ListNode node = new ListNode(tmp2.val);
                dummy.next = node;
                dummy = dummy.next;
                tmp2 = tmp2.next;
            }
            else{
                ListNode node = new ListNode(tmp1.val);
                dummy.next = node;
                dummy = dummy.next;
                tmp1 = tmp1.next;
            }
        }

        while(tmp1!=null){
            ListNode node = new ListNode(tmp1.val);
            dummy.next = node;
            dummy = dummy.next;
            tmp1 = tmp1.next;
        }

        while(tmp2!=null){
            ListNode node = new ListNode(tmp2.val);
            dummy.next = node;
            dummy = dummy.next;
            tmp2 = tmp2.next;
        }
        return newNode.next;
    }
}