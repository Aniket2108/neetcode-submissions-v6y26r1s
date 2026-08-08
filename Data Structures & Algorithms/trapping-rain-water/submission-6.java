class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int maxLeft = height[0], maxRight = height[n-1];
        int left = 0, right = n-1;
        int trW = 0;

        while(left <= right){
            if(height[left] <= height[right]){
                if(height[left] >= maxLeft){
                    maxLeft = height[left];
                }
                else{
                    trW += maxLeft-height[left];
                }
                left++;
            }
            else{
                if(height[right] >= maxRight){
                    maxRight = height[right];
                }
                else{
                    trW += maxRight-height[right];
                }
                right--;
            }
        }
        return trW;
    }
}
