class Solution {
    public int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int ans = 0;

        for (int num : nums) {
            start = Math.max(start, num);
            end += num;
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (check(mid, nums, k)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private boolean check(int mid, int[] arr, int k) {
        int sum = 0;
        int count = 0;

        for (int num : arr) {
            if (num > mid) {
                return false;
            }
            if (sum + num > mid) {
                count++;
                sum = num;
            } else {
                sum += num;
            }
        }

        count++;
        return count <= k;
    }
}