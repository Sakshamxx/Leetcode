class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        int s1 = 0; // Strat nums1
        int i = 0; // Track nums1
        int s2 = 0; // Start nums2
        int j = 0; // Track nums2
        int ans = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                int sum1 = 0;
                for (int k = s1; k <= i; k++) {
                    sum1 += nums1[k];
                }

                int sum2 = 0;
                for (int k = s2; k <= j; k++) {
                    sum2 += nums2[k];
                }
                
                ans += Math.max(sum1, sum2);
                i++;
                j++;
                s1 = i;
                s2 = j;
            }
        }
        // Remaining elements of nums1
        int sum1 = 0;
        while (i < nums1.length) {
            sum1 += nums1[i];
            i++;
        }

        // Remaining elements of nums2
        int sum2 = 0;
        while (j < nums2.length) {
            sum2 += nums2[j];
            j++;
        }
        ans += Math.max(sum1, sum2);

        return ans;
    }
}