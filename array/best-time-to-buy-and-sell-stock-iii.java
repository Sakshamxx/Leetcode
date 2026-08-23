class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;

        int first = 0;
        int second = 0;

        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < min) {
                min = prices[i];
            }

            int current = prices[i] - min;

            if (current < 0) {
                current = 0;
            }

            if (current > first) {
                second = first;
                first = current;
            } else if (current > second) {
                second = current;
            }

            min = prices[i];
        }

        return first + second;
    }
}