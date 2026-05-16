class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int trapW = 0;
        int[] nge = new int[n];
        int[] pge = new int[n];

        pge[0] = height[0];
        for(int i=1;i<n;i++){
            pge[i] = Math.max(pge[i-1],height[i]);
        }

        nge[n-1] = height[n-1];
        for(int i=n-2;i>=0;i--){
            nge[i] = Math.max(nge[i+1],height[i]);
        }
        
        for(int i=0;i<n;i++){
            trapW += Math.min(nge[i],pge[i]) - height[i];
        }
        return trapW;
    }
}
