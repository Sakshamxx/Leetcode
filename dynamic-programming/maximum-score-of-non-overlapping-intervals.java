import java.util.*;

class Solution {

    class Interval {
        int start;
        int end;
        int weight;
        int index;

        Interval(int start, int end, int weight, int index) {
            this.start = start;
            this.end = end;
            this.weight = weight;
            this.index = index;
        }
    }

    class State {
        long score;
        List<Integer> indices;

        State(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    Interval[] arr;
    State[][] dp;
    int n;

    public int[] maximumWeight(List<List<Integer>> intervals) {

        n = intervals.size();
        arr = new Interval[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Interval(
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            );
        }

        Arrays.sort(arr, (a, b) -> {
            if (a.start != b.start) {
                return Integer.compare(a.start, b.start);
            }
            return Integer.compare(a.end, b.end);
        });

        dp = new State[n + 1][5];

        State result = solve(0, 0);

        int[] answer = new int[result.indices.size()];

        for (int i = 0; i < result.indices.size(); i++) {
            answer[i] = result.indices.get(i);
        }

        return answer;
    }

    private State solve(int i, int chosen) {

        if (i == n || chosen == 4) {
            return new State(0L, new ArrayList<>());
        }

        if (dp[i][chosen] != null) {
            return dp[i][chosen];
        }

        // Don't take current interval
        State skip = solve(i + 1, chosen);

        // Take current interval
        int next = findNext(i);

        State nextState = solve(next, chosen + 1);

        List<Integer> indices =
            new ArrayList<>(nextState.indices);

        indices.add(arr[i].index);

        Collections.sort(indices);

        State take = new State(
            arr[i].weight + nextState.score,
            indices
        );

        dp[i][chosen] = better(take, skip);

        return dp[i][chosen];
    }

    private int findNext(int i) {

        int left = i + 1;
        int right = n;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid].start > arr[i].end) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private State better(State a, State b) {

        if (a.score != b.score) {
            return a.score > b.score ? a : b;
        }

        if (isSmaller(a.indices, b.indices)) {
            return a;
        }

        return b;
    }

    private boolean isSmaller(
        List<Integer> a,
        List<Integer> b
    ) {

        int size = Math.min(a.size(), b.size());

        for (int i = 0; i < size; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return a.get(i) < b.get(i);
            }
        }

        return a.size() < b.size();
    }
}