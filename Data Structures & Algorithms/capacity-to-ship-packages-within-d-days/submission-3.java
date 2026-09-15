class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int[] res = max(weights);
        int max = res[0], sum = res[1];

        int low = max, high = sum;

        while(low <= high){
            int mid = low + (high-low)/2;

            if(daysToShip(weights,mid) <= days){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return low;

    }

    private int daysToShip(int[] weights,int cap){
        int days = 1;
        int sum = 0;

        for(int i=0;i<weights.length;i++){
            if(sum + weights[i] <= cap){
                sum += weights[i];
            }
            else{
                days++;
                sum = weights[i];
            }
        }
        return days;
    }

    private int[] max(int[] weights){
        int max = Integer.MIN_VALUE, sum = 0;

        for(int i:weights){
            max = Math.max(i,max);
            sum += i;
        }

        return new int[]{max,sum};
    }
}