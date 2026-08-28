import java.util.*;

class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] freq = new int[26];

        for (char c : s.toCharArray())
            freq[c - 'a']++;

        int odd = 0;
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                odd++;
                middle = (char) ('a' + i);
            }
        }

        if (odd > 1)
            return "";

        int halfLen = n / 2;
        int[] halfFreq = new int[26];

        for (int i = 0; i < 26; i++)
            halfFreq[i] = freq[i] / 2;

        char[] half = new char[halfLen];

        for (int i = 0; i < halfLen; i++) {
            int c = target.charAt(i) - 'a';

            if (halfFreq[c] > 0) {
                half[i] = (char) ('a' + c);
                halfFreq[c]--;
            } else {
                return buildGreater(half, i, halfFreq, target, middle, n);
            }
        }

        String ans = buildPalindrome(half, middle, n);

        if (ans.compareTo(target) > 0)
            return ans;

        for (int i = halfLen - 1; i >= 0; i--) {
            halfFreq[half[i] - 'a']++;

            int c = target.charAt(i) - 'a';

            for (int x = c + 1; x < 26; x++) {
                if (halfFreq[x] == 0)
                    continue;

                half[i] = (char) ('a' + x);
                halfFreq[x]--;

                int pos = i + 1;

                for (int y = 0; y < 26; y++) {
                    while (halfFreq[y] > 0) {
                        half[pos++] = (char) ('a' + y);
                        halfFreq[y]--;
                    }
                }

                ans = buildPalindrome(half, middle, n);

                if (ans.compareTo(target) > 0)
                    return ans;

                Arrays.fill(halfFreq, 0);

                for (char ch : half)
                    halfFreq[ch - 'a']++;
            }
        }

        return "";
    }

    private String buildGreater(char[] half, int pos, int[] freq, String target, char middle, int n) {
        int c = target.charAt(pos) - 'a';

        for (int x = c + 1; x < 26; x++) {
            if (freq[x] == 0)
                continue;

            half[pos] = (char) ('a' + x);
            freq[x]--;

            int index = pos + 1;

            for (int y = 0; y < 26; y++) {
                while (freq[y] > 0) {
                    half[index++] = (char) ('a' + y);
                    freq[y]--;
                }
            }

            String ans = buildPalindrome(half, middle, n);

            if (ans.compareTo(target) > 0)
                return ans;

            Arrays.fill(freq, 0);

            for (char ch : half)
                freq[ch - 'a']++;
        }

        for (int i = pos - 1; i >= 0; i--) {
            freq[half[i] - 'a']++;

            int targetChar = target.charAt(i) - 'a';

            for (int x = targetChar + 1; x < 26; x++) {
                if (freq[x] == 0)
                    continue;

                half[i] = (char) ('a' + x);
                freq[x]--;

                int index = i + 1;

                for (int y = 0; y < 26; y++) {
                    while (freq[y] > 0) {
                        half[index++] = (char) ('a' + y);
                        freq[y]--;
                    }
                }

                String ans = buildPalindrome(half, middle, n);

                if (ans.compareTo(target) > 0)
                    return ans;

                Arrays.fill(freq, 0);

                for (char ch : half)
                    freq[ch - 'a']++;
            }
        }

        return "";
    }

    private String buildPalindrome(char[] half, char middle, int n) {
        StringBuilder sb = new StringBuilder(n);

        for (char c : half)
            sb.append(c);

        if (n % 2 == 1)
            sb.append(middle);

        for (int i = half.length - 1; i >= 0; i--)
            sb.append(half[i]);

        return sb.toString();
    }
}