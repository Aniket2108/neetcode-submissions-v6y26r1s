class PrefixTree {

    private Node root;

    public PrefixTree() {
         root = new Node();
    }

    public void insert(String word) {
        Node node = root;

        for(int i=0;i<word.length();i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i),new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public boolean search(String word) {
        Node node = root;
        for(char ch:word.toCharArray()){
            if(!node.containsKey(ch)){
                return false;
            }
            node = node.get(ch);
        }
        return node.isEnd();
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for(char ch:prefix.toCharArray()){
            if(!node.containsKey(ch)){
                return false;
            }
            node = node.get(ch);
        }
        return true;
    }
}

class Node{
    Node[] links = new Node[26];
    boolean flag = false;

    public Node(){}

    public boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }

    public Node get(char ch){
        return links[ch - 'a'];
    }

    public void put(char ch,Node node){
        links[ch - 'a'] = node;
    }

    public void setEnd(){
        flag = true;
    }

    public boolean isEnd(){
        return flag;
    }
}
