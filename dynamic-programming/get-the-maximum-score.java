class Solution {
    public int maxSum(int[] nums1, int[] nums2) {

        int s1 = 0;
        int i = 0;

        int s2 = 0;
        int j = 0;

        long ans = 0;

        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] < nums2[j]) {
                i++;
            }

            else if (nums1[i] > nums2[j]) {
                j++;
            }

            else {

                long sum1 = 0;

                for (int k = s1; k <= i; k++) {
                    sum1 += nums1[k];
                }

                long sum2 = 0;

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

        long sum1 = 0;

        while (i < nums1.length) {
            sum1 += nums1[i];
            i++;
        }

        long sum2 = 0;

        while (j < nums2.length) {
            sum2 += nums2[j];
            j++;
        }

        ans += Math.max(sum1, sum2);

        return (int) ans;
    }
}