class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0, right = n-1;
        int maxLeft = height[0], maxRight = height[n-1];
        int res = 0;

        while(left <= right){
            if(height[left] <= height[right]){
                if(maxLeft <= height[left]){
                    maxLeft = height[left];
                }
                else{
                    res += maxLeft - height[left];
                }
                left++;
            }
            else{
                if(maxRight <= height[right]){
                    maxRight = height[right];
                }
                else{
                    res += maxRight - height[right];
                }
                right--;
            }
        }
        return res;
    }
}
