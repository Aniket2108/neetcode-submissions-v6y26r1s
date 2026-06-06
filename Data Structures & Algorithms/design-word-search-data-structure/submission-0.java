class WordDictionary {

    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean flag = false;
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for(char c:word.toCharArray()){
            if(node.children[c - 'a'] == null){
                node.children[c - 'a'] = new TrieNode(); 
            }
            node = node.children[c - 'a'];
        }
        node.flag = true;
    }

    public boolean search(String word) {
        return dfs(0,word,root);
    }

    public boolean dfs(int idx,String word,TrieNode root){
        if(idx == word.length()){
            return root.flag;
        }

        char ch = word.charAt(idx);

        if(ch == '.'){
            for(TrieNode child:root.children){
                if(child != null && dfs(idx + 1,word,child)){
                    return true;
                }
            }
            return false;
        }

        if(root.children[ch - 'a'] == null){
            return false;
        }

        return dfs(idx + 1,word,root.children[ch - 'a']);
    }
}
