class MyHashMap {

    class Node{
        int key;
        int val;
        Node next;

        public Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }

    Node[] buckets;
    int size;

    public MyHashMap() {
        size = 1000;
        buckets = new Node[size];
    }

    public int hash(int key){
        return key%size;
    }

    private Node getPrev(Node cur,int key){
        while(cur.next!=null && cur.next.key != key){
            cur = cur.next;
        }
        return cur;
    }
    
    public void put(int key, int val) {
        int index = hash(key);

        if(buckets[index] == null){
            buckets[index] = new Node(-1,-1);
        }

        Node prev = getPrev(buckets[index],key);

        if(prev.next == null){
            prev.next = new Node(key,val);
        }
        else{
            prev.next.val = val;
        }
    }
    
    public int get(int key) {
        int index = hash(key);

        if(buckets[index] == null){
            return -1;
        }
        Node prev = getPrev(buckets[index],key);
 
        return prev.next == null ? -1 : prev.next.val;      
    }
    
    public void remove(int key) {
        int index = hash(key);

        if(buckets[index] == null){
            return;
        }
        Node prev = getPrev(buckets[index],key);

        if(prev.next != null){
            prev.next = prev.next.next;
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