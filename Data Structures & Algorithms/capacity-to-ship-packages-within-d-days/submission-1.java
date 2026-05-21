class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int res[] = max(weights);
        int max = res[0], sum = res[1];

        for(int i=max;i<=sum;i++){
            if(shipped(weights,i) <= days){
                return  i;
            }
        }
        return -1;
    }

    public int shipped(int[] weights,int cap){
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


    public int[] max(int[] weights){
        int max = Integer.MIN_VALUE, sum = 0;

        for(int i:weights){
            sum += i;
            max = Math.max(i,max);
        }

        return new int[]{max,sum};
    }
}