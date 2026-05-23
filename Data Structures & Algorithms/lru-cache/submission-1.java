class LRUCache {

    Map<Integer,ListNode> map;
    int capacity;
    ListNode head,tail;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.capacity = capacity;
        head = new ListNode(0,0);
        tail = new ListNode(0,0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        ListNode node = map.get(key);
        delNode(node);
        insertAtFront(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            delNode(node);
            node.val = value;
            insertAtFront(node);
            return;
        }
        else{
            if(map.size() == capacity){
                ListNode lru = tail.prev;
                delNode(lru);
                map.remove(lru.key);
            }
        }
        ListNode newNode = new ListNode(key,value);
        insertAtFront(newNode);
        map.put(key,newNode);
    }

    private void delNode(ListNode node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void insertAtFront(ListNode node){
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
}

class ListNode{
    int key;
    int val;
    ListNode next;
    ListNode prev;

    public ListNode(int key,int value){
        this.key = key;
        this.val = value;
    }
}
