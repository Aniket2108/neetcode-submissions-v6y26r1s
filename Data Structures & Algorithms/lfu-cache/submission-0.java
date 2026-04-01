class LFUCache {

    int capacity, minFreq;
    Map<Integer,Node> nodeMap;
    Map<Integer,DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        minFreq = 0;
        nodeMap = new HashMap<>();
        freqMap = new HashMap<>();
    }
    
    public int get(int key) {
        if(!nodeMap.containsKey(key)){
                return -1;
        }
        Node node = nodeMap.get(key);
        updateFreq(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(capacity == 0){
                return;
        }
        if(nodeMap.containsKey(key)){
                Node node = nodeMap.get(key);
                node.val = value;
                updateFreq(node);
                return;
        }
        if(nodeMap.size() == capacity){
                DoublyLinkedList list = freqMap.get(minFreq);
                Node removeNode = list.removeLast();
                nodeMap.remove(removeNode.key);
        }

        Node newNode = new Node(key,value);
        minFreq = 1;
        DoublyLinkedList list = freqMap.getOrDefault(1,new DoublyLinkedList());
        list.add(newNode);
        freqMap.put(1,list);
        nodeMap.put(key,newNode);
    }

    private void updateFreq(Node node){
        int freq = node.freq;
        DoublyLinkedList list = freqMap.get(freq);
        list.remove(node);

        if(freq == minFreq && list.size==0){
                minFreq++;
        }
        node.freq++;
        DoublyLinkedList newlist = freqMap.getOrDefault(node.freq,new DoublyLinkedList());
        newlist.add(node);
        freqMap.put(node.freq,newlist);
    }
}

class Node{
        Node next;
        Node prev;
        int val;
        int key;
        int freq;

        public Node(int key,int val){
                this.key = key;
                this.val = val;
                this.freq = 1;
        }
}

class DoublyLinkedList{
        Node head;
        Node tail;
        int size;

        public DoublyLinkedList(){
                head = new Node(0,0);
                tail = new Node(0,0);
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
                node.prev.next = node.next;
                node.next.prev = node.prev;
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