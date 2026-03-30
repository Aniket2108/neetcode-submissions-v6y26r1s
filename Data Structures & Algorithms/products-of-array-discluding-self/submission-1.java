class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] pref = new int[nums.length];
        int[] suff = new int[nums.length];

        pref[0] = 1;
        for(int i=1;i<pref.length;i++){
            pref[i] = pref[i-1] * nums[i-1];
        }
        suff[suff.length-1] = 1;
        for(int i=suff.length-2;i>=0;i--){
            suff[i] = suff[i+1] * nums[i+1];
        }
        for(int i=0;i<nums.length;i++){
            res[i] = pref[i] * suff[i];
        }
        return res;
    }
}  
