class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int i=0;i<matrix.length;i++){
            if(search(matrix[i],target)){
                return true;
            }
        }
        return false;
    }

    public boolean search(int[] nums, int target) {
        int low=0,high=nums.length-1;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                return true;
            }
            else if(nums[mid] > target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return false;
    }
}
