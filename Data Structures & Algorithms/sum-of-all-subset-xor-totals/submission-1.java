class Solution {
    public int subsetXORSum(int[] nums) {
        return subsetXORSum(0,0,nums);
    }

    private int subsetXORSum(int i,int total,int[] nums){
        if(i == nums.length) return total;
        return subsetXORSum(i+1,total ^ nums[i],nums) + subsetXORSum(i+1,total,nums);
    }
}