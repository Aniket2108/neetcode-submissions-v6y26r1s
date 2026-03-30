class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;
       int[] res = new int[n];

       for(int i=0;i<n;i++){
        int j = i;
        while(j > 0 && nums[j] < nums[j-1]){
            int temp = nums[j-1];
            nums[j-1] = nums[j];
            nums[j] = temp;
            j--;
        }
       }

       for(int i=0;i<n;i++){
        res[i] = nums[i];
       }
       return res;
    }
}