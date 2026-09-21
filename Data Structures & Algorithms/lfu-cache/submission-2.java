class LFUCache {

    Map<Integer,Node> nodeMap;
    Map<Integer,DoublyLinkedList> freqMap;
    int capacity;
    int minFreq;

    public LFUCache(int capacity) {
        nodeMap = new HashMap<>();
        freqMap = new HashMap<>();
        this.capacity = capacity;
        this.minFreq = 0;
    }
    
    public int get(int key) {
        if(!nodeMap.containsKey(key)){
            return -1;
        }
        Node node = nodeMap.get(key);
        updateFreq(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(nodeMap.containsKey(key)){
            Node node = nodeMap.get(key);
            node.value = value;
            updateFreq(node);
            return;
        }
        else{
            if(nodeMap.size() == capacity){
                DoublyLinkedList list = freqMap.get(minFreq);
                Node node = list.removeLast();
                nodeMap.remove(node.key);
            }
        }
        Node newNode = new Node(key,value);
        minFreq = 1;
        DoublyLinkedList list = freqMap.getOrDefault(1,new DoublyLinkedList());
        list.add(newNode);
        freqMap.put(1,list);
        nodeMap.put(key,newNode);
    }

    private void updateFreq(Node node){
        DoublyLinkedList list = freqMap.get(node.freq);
        list.remove(node);
        if(node.freq == minFreq && list.size == 0){
            minFreq++;
        }
        node.freq++;
        DoublyLinkedList newList = freqMap.getOrDefault(node.freq,new DoublyLinkedList());
        newList.add(node);
        freqMap.put(node.freq,newList);
    }
}

class Node{
    Node next;
    Node prev;
    int key;
    int value;
    int freq;

    public Node(int key,int value){
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}

class DoublyLinkedList{
    Node head;
    Node tail;
    int size;

    public DoublyLinkedList(){
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void add(Node node){
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
        size++;
    }

    public void remove(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
        size--;
    }

    public Node removeLast(){
        if(size > 0){
            Node last = tail.prev;
            remove(last);
            return last;
        }
        return null;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */