class Solution {
    public int trap(int[] height) {
        int[] nge = new int[height.length];
        int[] pge = new int[height.length];

        nge[0] = height[0];
        for(int i=1;i<height.length;i++){
            nge[i] = Math.max(height[i],nge[i-1]);
        }

        pge[pge.length-1] = height[height.length-1]; 
        for(int i=height.length-2;i>=0;i--){
            pge[i] = Math.max(height[i],pge[i+1]);
        }

        int trapW = 0;

        for(int i=0;i<height.length;i++){
            trapW += Math.min(nge[i],pge[i])-height[i];
        }
        return trapW;
    }
}
