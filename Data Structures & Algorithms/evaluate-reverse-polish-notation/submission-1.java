class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<tokens.length;i++){
            if(tokens[i].equals("+")){
                int right = st.pop();
                int left = st.pop();
                st.push(left+right);
            }
            else if(tokens[i].equals("-")){
                int right = st.pop();
                int left = st.pop();
                st.push(left-right);
            }
            else if(tokens[i].equals("*")){
                int right = st.pop();
                int left = st.pop();
                st.push(left*right);
            }
            else if(tokens[i].equals("/")){
                int right = st.pop();
                int left = st.pop();
                st.push(left/right);
            }
            else{
                st.push(Integer.valueOf(tokens[i]));
            }
        }
        return st.pop();
    }
}
