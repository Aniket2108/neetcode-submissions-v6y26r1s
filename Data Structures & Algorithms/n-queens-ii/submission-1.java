class Solution {
    int count = 0;
    Set<Integer> cols = new HashSet<>();
    Set<Integer> diag1 = new HashSet<>();
    Set<Integer> diag2 = new HashSet<>();
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        solveNQueens(0,board,n);
        return count;
    }

    public void solveNQueens(int row,char[][] board,int n){
        if(row == n){
            count++;
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
}

