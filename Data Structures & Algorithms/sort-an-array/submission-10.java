class Solution {
    public int[] sortArray(int[] nums) {
        int n = nums.length;

        quickSort(nums,0,n-1);

       return nums;
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);

            quickSort(arr, low, pIndex - 1);
            quickSort(arr, pIndex + 1, high);
        }
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[low];  

        int i = low + 1;
        int j = high;

        while (i <= j) {

            while (i <= high && arr[i] <= pivot) i++;
            while (j >= low + 1 && arr[j] > pivot) j--;

            if (i < j) {
                swap(arr, i, j);
            }
        }

        swap(arr, low, j);

        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}