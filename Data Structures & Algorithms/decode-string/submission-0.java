class Solution {
    public String decodeString(String s) {
       Stack<Character> st = new Stack<>();

       for(int i=0;i<s.length();i++){
        char c = s.charAt(i);
        if(c!= ']'){
            st.push(c);
        }
        else{
            String str = "";
            while(!st.isEmpty() && st.peek()!='['){
                str = st.pop() + str;
            }
            st.pop();
            String k = "";
            while(!st.isEmpty() && Character.isDigit(st.peek())){
                k = st.pop() + k;
            }
            int count = Integer.parseInt(k.toString());
            String repeated = str.toString().repeat(count);

            for (char ch : repeated.toCharArray()) {
                st.push(ch);
            }
        }
       } 
       String res = "";
       for(char c:st){
        res += c;
       }
       return res;
    }
}