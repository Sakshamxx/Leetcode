class Solution {
    public int minimumLength(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end && s.charAt(start) == s.charAt(end)){
            char ch = s.charAt(start);
            while (start <= end && s.charAt(start) == ch){
                start++;
            }
            while(end > start && s.charAt(end) == ch){
                end--;
            }
        }
        return end - start + 1;
    }
}