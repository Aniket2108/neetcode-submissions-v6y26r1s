class Solution {
    List<List<String>> res = new ArrayList<>();
    Set<Integer> cols = new HashSet<>();
    Set<Integer> diag1 = new HashSet<>();
    Set<Integer> diag2 = new HashSet<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        solveNQueens(0,board,n);
        return res;
    }

    public void solveNQueens(int row,char[][] board,int n){
        if(row == n){
            res.add(buildBoard(board));
            return;
        }


        for(int col=0;col<n;col++){
            if(cols.contains(col) || diag1.contains(row-col) || diag2.contains(row+col)){
                continue;
            }
            board[row][col] = 'Q';
            cols.add(col);
            diag1.add(row-col);
            diag2.add(row+col);
            solveNQueens(row+1,board,n);
            board[row][col] = '.';
            cols.remove(col);
            diag1.remove(row-col);
            diag2.remove(row+col);
        }
    }

    public List<String> buildBoard(char[][] board){
        List<String> tmp = new ArrayList<>();
        for(char[] row:board){
            tmp.add(new String(row));
        }
        return tmp;
    }
}
