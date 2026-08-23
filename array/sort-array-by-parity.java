class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while ( left < right){
            if (nums[right]%2 != 0 && left < right){
                right--;
            }if (nums[left]%2 == 0 && left < right){
                left ++;
            }if (nums[left]%2 != 0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        return nums;
    }
}