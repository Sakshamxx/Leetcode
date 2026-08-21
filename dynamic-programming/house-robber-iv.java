class Solution {

    private boolean canRob(int[] nums, int capability, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= capability) {
                count++;
                i++; 
            }
        }
        return count >= k;
    }

    public int minCapability(int[] nums, int k) {
        int low = 1;
        int high = 0;
        for (int num : nums) {
            high = Math.max(high, num);
        }
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canRob(nums, mid, k)) {
                ans = mid;
                high = mid - 1;
            } 
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
}