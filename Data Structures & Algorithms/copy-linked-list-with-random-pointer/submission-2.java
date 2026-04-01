/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        Node tmp = head;

        while(tmp!=null){
                Node next = tmp.next;
                Node copy = new Node(tmp.val);
                copy.next = next;
                tmp.next = copy;
                tmp = next;
        }

        tmp = head;

        while(tmp!=null){
                Node copy = tmp.next;
                if(tmp.random != null){
                        copy.random = tmp.random.next;
                }
                tmp = tmp.next.next;
        }
        tmp = head;
        Node dummy = new Node(0);
        Node res = dummy;

        while(tmp != null){
                res.next = tmp.next;
                res = res.next;
                tmp.next = tmp.next.next;
                tmp = tmp.next;
        }
        return dummy.next;
    }
}
