class Solution {
    public double myPow(double x, int n) {
        double ans = 1;

        while(n < 0){
            ans = ans*(1/x);
            n++;
        }

        while(n > 0){
            ans = ans * x;
            n--;
        }
        return ans;
    }
}
