class Solution {
    public List<String> braceExpansionII(String expression) {
        return new ArrayList<>(parse(expression, 0).set);
    }

    private static class Result {
        Set<String> set;
        int index;

        Result(Set<String> set, int index) {
            this.set = set;
            this.index = index;
        }
    }

    private Result parse(String s, int index) {
        Set<String> result = new TreeSet<>();
        Set<String> current = new TreeSet<>();
        current.add("");

        while (index < s.length() && s.charAt(index) != '}') {
            if (s.charAt(index) == '{') {
                Result sub = parse(s, index + 1);
                index = sub.index + 1;
                current = multiply(current, sub.set);
            } else if (s.charAt(index) == ',') {
                result.addAll(current);
                current = new TreeSet<>();
                current.add("");
                index++;
            } else {
                StringBuilder word = new StringBuilder();

                while (index < s.length() &&
                       Character.isLetter(s.charAt(index))) {
                    word.append(s.charAt(index));
                    index++;
                }

                Set<String> wordSet = new TreeSet<>();
                wordSet.add(word.toString());

                current = multiply(current, wordSet);
            }
        }

        result.addAll(current);
        return new Result(result, index);
    }

    private Set<String> multiply(Set<String> a, Set<String> b) {
        Set<String> result = new TreeSet<>();

        for (String x : a) {
            for (String y : b) {
                result.add(x + y);
            }
        }

        return result;
    }
}