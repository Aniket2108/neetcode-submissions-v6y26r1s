class LRUCache {

    Map<Integer,Node> nodeMap;
    Node head;
    Node tail;
    int size;

    public LRUCache(int capacity) {
        this.size = capacity;
        nodeMap = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!nodeMap.containsKey(key)){
            return -1;
        }
        Node node = nodeMap.get(key);
        delNode(node);
        insertAtFront(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(nodeMap.containsKey(key)){
            Node node = nodeMap.get(key);
            delNode(node);
            node.value = value;
            insertAtFront(node);
            return;
        }
        else{
            if(nodeMap.size() == size){
                Node lru = tail.prev;
                delNode(lru);
                nodeMap.remove(lru.key);
            }
        }
        Node node = new Node(key,value);
        insertAtFront(node);
        nodeMap.put(key,node);
    }

    private void delNode(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void insertAtFront(Node node){
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
}

class Node{
    Node next;
    Node prev;
    int key;
    int value;

    public Node(int key,int value){
        this.key = key;
        this.value = value;
    }
}
