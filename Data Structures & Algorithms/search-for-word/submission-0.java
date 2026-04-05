class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board,i,j,0,word)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board,int r,int c,int idx,String word){
        if(idx == word.length()) return true;
        if(r >= board.length || c >= board[0].length || c < 0 || r < 0 || board[r][c] != word.charAt(idx)){
            return false;
        }
        char tmp = board[r][c];
        board[r][c] = '#';

        boolean found = dfs(board,r+1,c,idx+1,word) || dfs(board,r-1,c,idx+1,word) || dfs(board,r,c+1,idx+1,word) || dfs(board,r,c-1,idx+1,word);
        board[r][c] = tmp;
        return found;
    }
}
