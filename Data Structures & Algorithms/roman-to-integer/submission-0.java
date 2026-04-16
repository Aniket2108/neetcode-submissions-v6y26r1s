class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        for(int i=0;i<s.length();i++){
            int a1 = romanChar(s.charAt(i));
            if(i+1 < s.length()){
                int a2 = romanChar(s.charAt(i+1));
                if(a1 >= a2){
                    sum += a1;
                }
                else{
                    sum -= a1;
                }
            }
            else{
                sum += a1;
            }
        }
        return sum;
    }
     public int romanChar(char c){
            if(c == 'I')
            return 1;
            if(c == 'V')
            return 5;
            if(c == 'X')
            return 10;
            if(c == 'L')
            return 50;
            if(c == 'C')
            return 100;
            if(c == 'D')
            return 500;
            if(c == 'M')
            return 1000;
            return -1;
 }
}