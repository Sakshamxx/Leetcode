class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int[] pos = new int[s.length()];
        int count = 0;
        String ans = "";

        for (int right = 0; right < s.length(); right++) {

            if (s.charAt(right) == '1') {
                pos[count] = right;
                count++;
            }

            if (count >= k) {

                int left = pos[count - k];

                String current = s.substring(left, right + 1);

                if (ans.equals("") ||
                    current.length() < ans.length() ||
                    (current.length() == ans.length()
                        && current.compareTo(ans) < 0)) {

                    ans = current;
                }
            }
        }

        return ans;
    }
}