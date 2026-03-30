class Solution {
    public int majorityElement(int[] nums) {
        int el=-1;
        int count = 0;

        for(int i=0;i<nums.length;i++){
            if(count == 0){
                count = 1;
                el = nums[i];
            }
            else if(nums[i] == el){
                count++;
            }
            else{
                count--;
            }
        }
        return el;
    }
}