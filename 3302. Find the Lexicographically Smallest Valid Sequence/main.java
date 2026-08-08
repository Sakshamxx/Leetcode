class Solution {
    public int[] validSequence(String w1, String w2) {
        int n = w1.length(), m = w2.length();

        // suf[i] = number of characters of w2's suffix
        // that can be matched exactly from w1[i...]
        int[] suf = new int[n + 1];

        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            suf[i] = suf[i + 1];

            if (j >= 0 && w1.charAt(i) == w2.charAt(j)) {
                suf[i]++;
                j--;
            }
        }

        int[] ans = new int[m];
        int k = 0;
        boolean changed = false;

        for (int i = 0; i < n && k < m; i++) {

            if (w1.charAt(i) == w2.charAt(k)) {
                ans[k++] = i;
            }
            else if (!changed && suf[i + 1] >= m - k - 1) {
                // Use our one allowed mismatch here
                ans[k++] = i;
                changed = true;
            }
        }

        return k == m ? ans : new int[0];
    }
}