class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int prod = 1;
        int ans = 0;
        while(end <= nums.length - 1){
            // Growing
            prod *= nums[end];
            // Shrinking
            while (prod >= k && start <= end){
                prod /= nums[start];
                start++;
            }
            // Answer
            ans += end - start + 1;
            end++;
        }
        return ans;
    }
}