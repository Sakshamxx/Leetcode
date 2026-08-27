class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            int t = target.charAt(i) - 'a';
            if (freq[t] > 0) {
                freq[t]--;
                ans.append(target.charAt(i));
                continue;
            }

            for (int c = t + 1; c < 26; c++) {
                if (freq[c] > 0) {
                    ans.append((char) ('a' + c));
                    freq[c]--;
                    for (int x = 0; x < 26; x++) {
                        while (freq[x] > 0) {
                            ans.append((char) ('a' + x));
                            freq[x]--;
                        }
                    }
                    return ans.toString();
                }
            }
            break;
        }

        for (int i = ans.length() - 1; i >= 0; i--) {
            int current = ans.charAt(i) - 'a';
            freq[current]++;
            for (int c = current + 1; c < 26; c++) {
                if (freq[c] > 0) {
                    StringBuilder result =
                            new StringBuilder(ans.substring(0, i));
                    result.append((char) ('a' + c));
                    freq[c]--;

                    for (int x = 0; x < 26; x++) {
                        while (freq[x] > 0) {
                            result.append((char) ('a' + x));
                            freq[x]--;
                        }
                    }
                    return result.toString();
                }
            }
        }

        return "";
    }
}