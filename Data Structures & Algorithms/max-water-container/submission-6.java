class Solution {
    public int maxArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        int right = heights.length-1, left = 0;

        while(left < right){
            maxArea = Math.max(maxArea,Math.min(heights[left],heights[right])*(right-left));
            if(heights[left] >= heights[right]){
                right--;
            }
            else{
                left++;
            }
        }
        
        
        return maxArea;
    }
}
