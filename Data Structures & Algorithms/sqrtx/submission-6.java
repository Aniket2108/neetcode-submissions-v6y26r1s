class Solution {
    public int mySqrt(int x) {
        long low=0,high=x;

        while(low <= high){
            long mid = low + (high-low)/2;
            long num = mid*mid;
            if(num == x){
                return (int) mid;
            }
            else if(num > x){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return (int) high;
    }
}