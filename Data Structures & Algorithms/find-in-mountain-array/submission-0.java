/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int l = 1, h = n-1;
        int peak = -1;

        while(l <= h){
            int m = l + (h-l)/2;
            int left = m-1, right = m+1;

            if(mountainArr.get(left) < mountainArr.get(m) && mountainArr.get(m) < mountainArr.get(right)){
                l = m+1;
            }
            else if(mountainArr.get(left) > mountainArr.get(m) && mountainArr.get(m)> mountainArr.get(right)){
                h = m-1;
            }
            else{
                peak = m;
                break;
            }
        }

        l = 0;h=peak;
        while(l<=h){
            int m = l + (h-l)/2;
            int val = mountainArr.get(m);
            if(val<target){
                l = m+1;
            }
            else if(val > target){
                h = m-1;
            }
            else{
                return m;
            }
        }

        l = peak+1;h=n-1;
        while(l<=h){
            int m = l + (h-l)/2;
            int val = mountainArr.get(m);
            if(val<target){
                h = m-1;
            }
            else if(val > target){
                l = m+1;
            }
            else{
                return m;
            }
        }
        return -1;
    }
}