class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int el1 = -1, el2 = -1;
        int count1 = 0, count2 = 0;

        for(int i=0;i<nums.length;i++){
            if(count1 == 0 && nums[i] != el2){
                el1 = nums[i];
                count1 = 1;
            }
            else if(count2 == 0 && nums[i] != el1){
                el2 = nums[i];
                count2 = 1;
            }
            else if(el1 == nums[i]){
                count1++;
            }
            else if(el2 == nums[i]){
                count2++;
            }
            else{
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;
        for(int i:nums){
            if(i==el1){
                count1++;
            }
            if(i==el2){
                count2++;
            }
        }

        List<Integer> result = new ArrayList<>();

        if (count1 > nums.length / 3) {
            result.add(el1);
        }

        if (count2 > nums.length / 3) {
            result.add(el2);
        }

        return result;
    }
}