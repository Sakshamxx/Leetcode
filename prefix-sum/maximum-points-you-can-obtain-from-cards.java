class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int window = n - k;
        int total = 0;

        for(int x : cardPoints){
            total+=x;
        }

        if (window == 0){
            return total;
        }
        int sum = 0;
        for (int i = 0; i<window;i++){
            sum += cardPoints[i];
        }
        int minWindow = sum;
                for (int i = window; i < n; i++) {

            sum += cardPoints[i];

            sum-= cardPoints[i - window];

            minWindow = Math.min(minWindow, sum);

        }

        return total - minWindow;
        }
    }