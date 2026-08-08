class MyHashMap {

    int size;
    Node[] buckets;

    public MyHashMap() {
        size = 16;
        buckets = new Node[16];
    }

    private int hash(int key){
        return key%size;
    }

    private Node getPrev(Node cur,int key){
        while(cur.next != null && cur.next.key != key){
            cur = cur.next;
        }
        return cur;
    }
    
    public void put(int key, int value) {
        int index = hash(key);

        if(buckets[index] == null){
            buckets[index] = new Node(-1,-1);
        }

        Node prev = getPrev(buckets[index],key);

        if(prev.next == null){
            prev.next = new Node(key,value);
        }
        else{
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int index = hash(key);

        if(buckets[index] == null){
            return -1;
        }

        Node prev = getPrev(buckets[index],key);

        if(prev.next == null){
            return -1;
        }
        else{
            return prev.next.value;
        }
    }
    
    public void remove(int key) {
        int index = hash(key);

        if(buckets[index] == null){
            return;
        }

        Node prev = getPrev(buckets[index],key);

        if(prev.next == null){
            return;
        }
        else{
            prev.next = prev.next.next;
        }
    }
}

class Node{
    int key;
    int value;
    Node next;

    public Node(int key,int value){
        this.key = key;
        this.value = value;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */