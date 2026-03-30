class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=0,high = findMax(piles);

        while(low <= high){
            int mid = low + (high-low)/2;
            int maxH = hourlyRate(piles,mid);
            if(maxH <= h){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        
    return low;
    }

    public int hourlyRate(int[] nums,int h){
        int maxH = 0;
        for(int i:nums){
            maxH += Math.ceil((double)i/(double)h);
        }
        return maxH;
    }

    public int findMax(int[] piles){
        int max = Integer.MIN_VALUE;
        for(int i:piles){
            max = Math.max(i,max);
        }
        return max;
    }
}
