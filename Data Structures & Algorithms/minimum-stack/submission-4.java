class MinStack {

    Stack<Pair> st;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            st.push(new Pair(val,val));
            return;
        }
        st.push(new Pair(val,Math.min(val,st.peek().min)));
    }
    
    public void pop() {
        st.pop();
    }
    
    public int top() {
        return st.peek().el;
    }
    
    public int getMin() {
        return st.peek().min;
    }
}

class Pair{
    int el;
    int min;

    public Pair(int el,int min){
        this.el = el;
        this.min = min;
    }
}
