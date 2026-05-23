class LFUCache {
    int capacity, minFreq;
    Map<Integer,ListNode> nodeMap;
    Map<Integer,DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {
        nodeMap = new HashMap<>();
        freqMap = new HashMap<>();
        this.capacity = capacity;
        minFreq = 0;
    }
    
    public int get(int key) {
        if(!nodeMap.containsKey(key)){
            return -1;
        }
        ListNode node = nodeMap.get(key);
        updateFreq(node);
        return node.value;
    }
    
    public void put(int key, int value) {
       if(capacity == 0){
        return;
       } 
       if(nodeMap.containsKey(key)){
        ListNode node = nodeMap.get(key);
        node.value = value;
        updateFreq(node);
        return;
       }
       if(nodeMap.size() == capacity){
        DoublyLinkedList list = freqMap.get(minFreq);
        ListNode remove = list.removeLast();
        nodeMap.remove(remove.key);
       }
       ListNode newNode = new ListNode(key,value);
       minFreq = 1;
       DoublyLinkedList list = freqMap.getOrDefault(1,new DoublyLinkedList());
       list.add(newNode);
       freqMap.put(1,list);
       nodeMap.put(key,newNode);
    }

    private void updateFreq(ListNode node){
        DoublyLinkedList list = freqMap.get(node.freq);
        list.remove(node);
        if(node.freq == minFreq && list.size==0){
                minFreq++;
        }
        node.freq++;
        DoublyLinkedList newList = freqMap.getOrDefault(node.freq,new DoublyLinkedList());
        newList.add(node);
        freqMap.put(node.freq,newList);
    }

}

class ListNode{
    int key;
    int value;
    int freq;
    ListNode next;
    ListNode prev;

    public ListNode(int key,int value){
        this.key = key;
        this.value = value;
        this.freq = 1;
    }
}

class DoublyLinkedList{
    ListNode head;
    ListNode tail;
    int size;

    public DoublyLinkedList(){
        head = new ListNode(-1,-1);
        tail = new ListNode(-1,-1);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void add(ListNode node){
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
        size++;
    }

    public void remove(ListNode node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
        size--;
    }

    public ListNode removeLast(){
        if(size > 0){
            ListNode last = tail.prev;
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