class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int i:asteroids){
            boolean alive = true;

            while(alive && i < 0 && !st.isEmpty() && st.peek() > 0){
                int el = st.peek();
                if(el < -i){
                    st.pop();
                }
                else if(el == -i){
                    st.pop();
                    alive = false;
                }
                else{
                    alive = false;
                }
            }


            if(alive){
                st.push(i);
            }
        }

        int[] res = new int[st.size()];
        for(int i=res.length-1;i>=0;i--){
            res[i] = st.pop();
        }
        return res;
    }
}