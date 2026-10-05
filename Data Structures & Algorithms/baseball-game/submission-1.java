class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        int total = 0;

        for(int i=0;i<operations.length;i++){
            if(operations[i].equals("+") && st.size() >= 2){
                int second = st.pop();
                int first = st.pop();
                st.push(first);
                st.push(second);
                st.push(first+second);
            }
            else if(operations[i].equals("D") && st.size()>0){
                st.push(2 * st.peek());
            }
            else if(operations[i].equals("C") && st.size()>0){
                st.pop();
            }
            else{
                st.push(Integer.valueOf(operations[i]));
            }
        }

        while(!st.isEmpty()){
            total += st.pop();
        }

        return total;
    }
}