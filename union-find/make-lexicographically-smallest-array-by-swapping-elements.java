class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        int[][] a = new int[n][2];

        for (int i = 0; i < n; i++) {
            a[i][0] = nums[i];
            a[i][1] = i;
        }

        Arrays.sort(a, (x, y) -> Integer.compare(x[0], y[0]));
        int start = 0;

        while (start < n) {
            int end = start;
            while (end + 1 < n && a[end + 1][0] - a[end][0] <= limit)
                end++;
            int[] indices = new int[end - start + 1];
            for (int i = start; i <= end; i++)
                indices[i - start] = a[i][1];
            Arrays.sort(indices);
            for (int i = 0; i < indices.length; i++)
                nums[indices[i]] = a[start + i][0];
            start = end + 1;
        }

        return nums;
    }
}