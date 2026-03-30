class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] nge = new int[n];
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        nge[n-1] = -1;
        st.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                nge[i] = -1;
            }
            else{
                nge[i] = st.peek();
            }
            st.push(i);
        }

        for(int i=0;i<n;i++){
            res[i] = nge[i] == -1 ? 0 :nge[i] - i;
        }

        return res;
    }
}