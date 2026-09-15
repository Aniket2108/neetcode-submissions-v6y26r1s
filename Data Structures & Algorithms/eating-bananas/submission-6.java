class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = findMax(piles);

        int low = 1, high = max;

        while(low <= high){
            int mid = low + (high-low)/2;
            if(eating(piles,mid) <= h){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }

        return low;
    }

    private int findMax(int[] piles){
        int max = Integer.MIN_VALUE;

        for(int i:piles){
            max = Math.max(i,max);
        }

        return max;
    }

    private int eating(int[] piles,int h){
        int max = 0;

        for(int i=0;i<piles.length;i++){
            max += Math.ceil((double)piles[i]/(double)h);
        }

        return max;
    }
}
