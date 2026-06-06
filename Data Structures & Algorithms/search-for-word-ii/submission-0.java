class Solution {
    class TrieNode{
        TrieNode[] children;
        String word;

        public TrieNode(){
            children = new TrieNode[26];
            word = null;
        }
    }

    List<String> res = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);

        int row = board.length;
        int col = board[0].length;

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                dfs(i,j,board,root);
            }
        }
        return res;
    }

    public void dfs(int row,int col,char[][] board,TrieNode root){
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;
        char ch = board[row][col];
        if(ch == '#') return;
        if(root.children[ch - 'a'] == null) return;

        root = root.children[ch - 'a'];

        if(root.word != null){
            res.add(root.word);
            root.word = null;
        }

        board[row][col] = '#';

        dfs(row + 1,col,board,root);
        dfs(row - 1,col,board,root);
        dfs(row,col + 1,board,root);
        dfs(row,col - 1,board,root);

        board[row][col] = ch;
    }

    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();

        for(String word:words){
            TrieNode node = root;
            for(char c:word.toCharArray()){
                if(node.children[c - 'a'] == null){
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.word = word;
        }
        return root;
    }
}
