class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int max = findMax(piles);
       
        int low = 1, high = max;

        while(low <= high){
            int mid = low + (high - low)/2;
            int maxH = eatingDone(piles,mid);

            if(maxH <= h){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        
        return low;
    }

    public int findMax(int[] piles){
        int max = Integer.MIN_VALUE;

        for(int i:piles){
            max = Math.max(max,i);
        }

        return max;
    }

    public int eatingDone(int[] piles,int h){
        int max = 0;

        for(int i:piles){
            max += Math.ceil((double)i/(double)h);
        }
        return max;
    }
}
