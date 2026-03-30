class MyHashMap {

    class Node{
        int key;
        int value;
        Node next;

        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    private int size = 1000;
    Node[] buckets;

    public int hash(int key){
        return key % size;
    }

    public MyHashMap() {
        buckets = new Node[size];
    }
    
    public void put(int key, int value) {
        int index = hash(key);
        if(buckets[index] == null){
            Node node = new Node(key,value);
            buckets[index] = node;
            return;
        }

        Node cur = buckets[index];
        while(true){
            if(cur.key == key){
                cur.value = value;
                return;
            }
            if (cur.next == null) break;
            cur = cur.next;
        }
            cur.next = new Node(key, value);
    }
    
    public int get(int key) {
        int index = hash(key);
        Node node = buckets[index];

        while(node != null){
            if(node.key == key){
                return node.value;
            }
            node = node.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        int index = hash(key);
        Node cur = buckets[index];
        Node prev = null;

        while (cur != null) {
            if (cur.key == key) {
                if (prev == null) {
                    buckets[index] = cur.next; 
                } else {
                    prev.next = cur.next;
                }
                return;
            }
            prev = cur;
            cur = cur.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */