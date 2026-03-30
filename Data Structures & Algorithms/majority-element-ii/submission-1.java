class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            int cnt = 0;
            for(int j=0;j<nums.length;j++){
                if(nums[i] == nums[j]){
                    cnt++;
                }
            }
            if(cnt > nums.length/3 && !list.contains(nums[i])){
                list.add(nums[i]);
                if(list.size() == 2){
                    break;
                }
            }
        }
        return list;
    }
}