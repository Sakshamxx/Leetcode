class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < prices.length; i++){
            if (prices[i] < min){
                min = prices[i];
            }
            int current = prices[i] - min;
            if (current < 0){
                current = 0;
            }
            sum+= current;
            min = prices[i];
        }
        return sum;
    }
}