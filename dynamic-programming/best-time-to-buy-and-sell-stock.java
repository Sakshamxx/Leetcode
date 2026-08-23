class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int maxprofit = 0;

        for (int i = 0; i < prices.length; i++){
            if (prices[i] < min){
                min = prices[i];
            }
            int current = prices[i] - min;
            maxprofit = Math.max(current, maxprofit);

        }
        return maxprofit;
    }
}