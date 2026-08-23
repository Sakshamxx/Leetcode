class Solution {
    public int maxProfit(int[] prices) {

        int buy1 = Integer.MAX_VALUE;
        int profit1 = 0;

        int buy2 = Integer.MAX_VALUE;
        int profit2 = 0;

        for (int price : prices) {

            // First transaction
            buy1 = Math.min(buy1, price);
            profit1 = Math.max(profit1, price - buy1);

            // Second transaction
            buy2 = Math.min(buy2, price - profit1);
            profit2 = Math.max(profit2, price - buy2);
        }

        return profit2;
    }
}