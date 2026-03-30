class MinStack {

    Stack<Long> st;
    long min;

    public MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        long diff = val - min;
        st.push(diff);

        if(diff<0){
            min = val;
        }
    }
    
    public void pop() {
        if(st.isEmpty()){
            return;
        }
        long diff = st.pop();
        if(diff < 0){
            min = min -diff;
        }
    }
    
    public int top() {
        long diff = st.peek();
        if(diff >= 0){
            return (int) (min+diff);
        }
        else{
            return (int) min;
        }
    }
    
    public int getMin() {
        return (int)min;
    }
}
