class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
       int[] res = new int[n];

       for(int i=n-1;i>=0;i--){
        for(int j=0;j<=i-1;j++){
            if(nums[j] > nums[j+1]){
                int temp = nums[j];
                nums[j] = nums[j+1];
                nums[j+1] = temp;
            }
        }
       } 

       for(int i=0;i<n;i++){
        res[i] = nums[i];
       }
       return res;
    }
}