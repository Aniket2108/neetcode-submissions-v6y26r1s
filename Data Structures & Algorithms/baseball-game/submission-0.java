class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;

        for(int i=0;i<operations.length;i++){
            if(operations[i].equals("+")){
                int secondElement = stack.pop();
                int firstElement = stack.pop();
                int sum = firstElement + secondElement;
                stack.push(firstElement);
                stack.push(secondElement);
                stack.push(sum);
            }
            else if(operations[i].equals("D")){
                int el = stack.pop();
                stack.push(el);
                stack.push(2*el);
            }
            else if(operations[i].equals("C")){
                stack.pop();
            }
            else{
                stack.push(Integer.valueOf(operations[i]));
            }
        }

        while(!stack.isEmpty()){
            ans += stack.pop();
        }
        return ans;
    }
}