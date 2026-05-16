class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int trapW = 0;
        int left = 0, right = n-1;
        int maxLeft = height[0], maxRight = height[n-1];

        while(left <= right){
            if(height[left] <= height[right]){
                if(maxLeft <= height[left]){
                    maxLeft = height[left];
                }
                else{
                    trapW += maxLeft - height[left];
                }
                left++;
            }
            else{
                if(maxRight <= height[right]){
                    maxRight = height[right];
                }
                else{
                    trapW += maxRight - height[right];
                }
                right--;
            }
        }
        return trapW;
    }
}
