class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = 0;
        int hi = 0;

        for (int w : weights) {
            lo = Math.max(lo, w);
            hi += w;
        }
        int ans = hi;
        while (lo <= hi) {

            int mid = lo + (hi - lo) / 2;

            if (canBeShipped(weights, mid) <= days) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return ans;
    }

    private int canBeShipped(int[] weights, int capacity) {
        int ships = 1;
        int current = 0;

        for (int w : weights) {
            if (current + w > capacity) {
                ships++;
                current = w;
            } else {
                current += w;
            }
        }
        return ships;
    }
}