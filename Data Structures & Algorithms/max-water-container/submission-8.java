class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int left = 0, right = n-1;
        int maxArea = 0;

        for(int i=0;i<n;i++){
            maxArea = Math.max(maxArea,Math.min(heights[left],heights[right])*(right-left));

            if(heights[left] > heights[right]){
                right--;
            }
            else{
                left++;
            }
        }
        return maxArea;
    }
}
