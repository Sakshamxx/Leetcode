class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int lsum = 0;
        int rsum = 0;
        int maxsum = 0;
        // Grow
        for (int i =0; i < k;i++){
            lsum += cardPoints[i];
            maxsum = lsum;
        }
        // Shrink
        int r_index = cardPoints.length - 1;
        for (int i =  k -1; i >= 0; i--){
            lsum -= cardPoints[i];
            rsum += cardPoints[r_index];
            r_index--;
            maxsum = Math.max(maxsum,lsum+rsum);
        }
        return maxsum;
    }
}