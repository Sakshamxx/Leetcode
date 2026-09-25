import java.util.*;

class Solution {
    int index = 0;
    public List<String> braceExpansionII(String expression) {
        Set<String> result = parse(expression);
        List<String> answer = new ArrayList<>(result);
        Collections.sort(answer);
        return answer;
    }

    private Set<String> parse(String expression) {
        Set<String> result = new HashSet<>();
        Set<String> current = new HashSet<>();
        current.add("");
        while (index < expression.length()
                && expression.charAt(index) != '}') {
            char ch = expression.charAt(index);
            if (ch == ',') {
                result.addAll(current);
                current = new HashSet<>();
                current.add("");
                index++;
            }
            else if (ch == '{') {
                index++; 
                Set<String> next = parse(expression);
                index++; 
                current = combine(current, next);
            }
            else {
                index++;
                Set<String> next = new HashSet<>();
                next.add(String.valueOf(ch));
                current = combine(current, next);
            }
        }
        result.addAll(current);
        return result;
    }

    private Set<String> combine(Set<String> first, Set<String> second) {
        Set<String> result = new HashSet<>();
        for (String a : first) {
            for (String b : second) {
                result.add(a + b);
            }
        }
        return result;
    }
}