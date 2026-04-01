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
        Map<Node,Node> map = new HashMap<>();
        Node tmp = head;

        while(tmp!=null){
                Node newNode = new Node(tmp.val);
                map.put(tmp,newNode);
                tmp = tmp.next;
        }

        tmp = head;

        while(tmp!=null){
                Node copy = map.get(tmp);
                copy.next = map.get(tmp.next);
                copy.random = map.get(tmp.random);
                tmp = tmp.next;
        }
        return map.get(head);
    }
}
