class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] best = new int[n];
        int INF = n + 1;

        for (int i = 0; i < n; i++) {
            best[i] = INF;
        }
        int left = 0;
        int sum = 0;
        int answer = INF;
        for (int right = 0; right < n; right++) {
            sum += arr[right];
            while (sum > target) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {
                int length = right - left + 1;

                if (left > 0 && best[left - 1] != INF) {
                    answer = Math.min(
                        answer,
                        length + best[left - 1]
                    );
                }

                if (right == 0) {
                    best[right] = length;
                } else {
                    best[right] = Math.min(best[right - 1], length);
                }
            } else {
                if (right > 0) {
                    best[right] = best[right - 1];
                }
            }
        }

        return answer == INF ? -1 : answer;
    }
}