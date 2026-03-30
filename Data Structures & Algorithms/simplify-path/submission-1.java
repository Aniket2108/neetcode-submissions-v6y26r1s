class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        StringBuilder sb = new StringBuilder();


        for(int i=0;i<=path.length();i++){
            if(i == path.length() || path.charAt(i) == '/'){
                String dir = sb.toString();
                if(dir.equals("..")){
                    if(!st.isEmpty()){
                        st.pop();
                    }
                }
                else if(!dir.equals("") && !dir.equals(".")){
                    st.push(dir);
                }
                sb.setLength(0);
            }
            else{
                sb.append(path.charAt(i));
            }
        }


        StringBuilder res = new StringBuilder();
        for (String dir : st) {
            res.append("/").append(dir);
        }

        return res.length() == 0 ? "/" : res.toString();
    }
}