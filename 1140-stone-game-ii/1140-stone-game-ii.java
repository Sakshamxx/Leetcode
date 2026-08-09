class Solution {
    int[][] dp;
    int[] suffix;
    int n;

    public int stoneGameII(int[] piles) {
        n = piles.length;
        dp = new int[n][n + 1];
        suffix = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }
        return solve(0, 1);
    }

    int solve(int i, int M) {
        if (i + 2 * M >= n)
            return suffix[i];

        if (dp[i][M] != 0)
            return dp[i][M];
        int best = 0;
        for (int X = 1; X <= 2 * M; X++) {
            int opponent = solve(i + X, Math.max(M, X));
            int current = suffix[i] - opponent;
            best = Math.max(best, current);
        }
        return dp[i][M] = best;
    }
}