class Solution {
    public int distinctSubseqII(String s) {
        long MOD = 1_000_000_007;
        long dp = 1;
        long[] last = new long[26];

        for (char c : s.toCharArray()) {
            int index = c - 'a';
            long newDp = (2 * dp - last[index] + MOD) % MOD;
            last[index] = dp;
            dp = newDp;
        }

        return (int) ((dp - 1 + MOD) % MOD);
    }
}