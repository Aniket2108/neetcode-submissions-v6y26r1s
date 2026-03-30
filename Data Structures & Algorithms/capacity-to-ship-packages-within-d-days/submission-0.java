class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int max = Integer.MIN_VALUE,sum=0;

        for(int i:weights){
            sum += i;
            max = Math.max(max,i);
        }

        int low = max, high = sum;

        while(low <= high){
            int mid = low + (high-low)/2;
            int time = findDays(weights,mid);
            if(time <= days){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
    return low;
    }

    public int findDays(int[] weights,int h){
        int days = 1, n = weights.length;
        int sum = 0;

        for(int i:weights){
            if(sum + i > h){
                days += 1;
                sum = i;
            }
            else{
                sum += i;
            }
        }
        return days;
    }

}