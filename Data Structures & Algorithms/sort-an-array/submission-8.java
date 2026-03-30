class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        mergeSort(nums,0,n-1);

       return nums;
    }

    public void mergeSort(int[] arr,int low,int high){
        if(low>=high) return;
        int mid = low + (high-low)/2;

        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }

    public void merge(int[] arr,int low,int mid,int high){
        List<Integer> list = new ArrayList<>();
        int left = low, right = mid+1;

        while(left <=mid && right <= high){
            if(arr[left] < arr[right]){
                list.add(arr[left++]);
            }
            else{
                list.add(arr[right++]);
            }
        }

        while(left <= mid){
            list.add(arr[left++]);
        }

        while(right <= high){
            list.add(arr[right++]);
        }

        for(int i=low;i<=high;i++){
            arr[i] = list.get(i-low);
        }
    }
}