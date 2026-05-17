class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new LinkedList<>();
        int i = floor(arr,x);
        int j = i+1;

        while(k > 0 && i >= 0 && j<arr.length){
            if(Math.abs(x-arr[i]) <= Math.abs(x-arr[j])){
                res.addFirst(arr[i--]);
            }
            else{
                res.addLast(arr[j++]);
            }
            k--;
        }

        while(k > 0 && i >= 0){
            res.addFirst(arr[i--]);
            k--;
        }

        while(k > 0 && j<arr.length){
            res.addLast(arr[j++]);
            k--;
        }
         return res;
    }

    private int floor(int[] arr,int k){
        int ans = 0;
        int low = 0, high = arr.length-1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(arr[mid] == k){
                return mid;
            }
            else if(arr[mid] < k){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
}