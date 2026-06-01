class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        StringBuilder sb = new StringBuilder();
        generateParenthesis(n,0,0,sb);
        return res;
    }

    private void generateParenthesis(int n,int open,int closed,StringBuilder sb){
        if(sb.length() == n*2){
            res.add(new String(sb));
            return;
        }
        if(open < n){
            sb.append('(');
            generateParenthesis(n,open+1,closed,sb);
            sb.deleteCharAt(sb.length()-1);
        }
        if(closed < open){
            sb.append(')');
            generateParenthesis(n,open,closed+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
