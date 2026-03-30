class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        int left = 0, right = n-1;

        while(left < right){
            maxArea = Math.max(maxArea,Math.min(heights[left],heights[right]) * (right-left));

            if(heights[right] >= heights[left]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxArea;
    }
}
