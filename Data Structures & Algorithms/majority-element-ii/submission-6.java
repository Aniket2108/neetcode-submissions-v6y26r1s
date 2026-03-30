class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();

        int cnt1=0, cnt2=0;
        int el1=Integer.MIN_VALUE,el2=Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            if(cnt1 == 0 && nums[i] != el2){
                cnt1 = 1;
                el1 = nums[i];
            }
            else if(cnt2 == 0 && nums[i] != el1){
                cnt2 = 1;
                el2 = nums[i];
            }
            else if(el1 == nums[i]){
                cnt1++;
            }
            else if(el2 == nums[i]){
                cnt2++;
            }
            else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for(int i:nums){
            if(i==el1){
                cnt1++;
            }
            if(i==el2){
                cnt2++;
            }
        }

        if(cnt1 > nums.length/3){
            list.add(el1);
        }
        if(cnt2 > nums.length/3){
            list.add(el2);
        }
        return list;
    }
}