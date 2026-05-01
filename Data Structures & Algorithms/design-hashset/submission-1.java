class MyHashSet {

    List<Integer>[] buckets;
    int size;

    public MyHashSet() {
        size = 1000;
        buckets = new LinkedList[size];
    }

    public int hash(int key){
        return key%size;
    }
    
    public void add(int key) {
        int index = hash(key);

        if(buckets[index] == null){
            buckets[index] = new LinkedList<>();
        }

        if(!buckets[index].contains(key)){
            buckets[index].add(key);
        }
    }
    
    public void remove(int key) {
        int index = hash(key);

        if (buckets[index] != null) {
            buckets[index].remove(Integer.valueOf(key));
        }

    }
    
    public boolean contains(int key) {
        int index = hash(key);

        return buckets[index] != null && buckets[index].contains(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */