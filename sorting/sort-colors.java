class Solution {

    private void swap(int[] arr, int a , int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while ( i <= right ){
            if ( nums[i] == 0) {
                swap(nums, i, left);
                left++;
                i++;
            }
            else if ( nums[i] == 1){
                i++;
            }
            else{
                swap(nums, i , right);
                right--;
            }
        }
    }
}