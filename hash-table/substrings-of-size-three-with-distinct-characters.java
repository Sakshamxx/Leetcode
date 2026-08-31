class Solution {
    public int countGoodSubstrings(String s) {
        int start = 0;
        int count = 0;
        int[] arr = new int[26];
        // Grow
        for (int i =0 ;i < s.length(); i++){
            arr[s.charAt(i) - 'a']++;
            int range = i - start + 1;

            if (range == 3){
                if (isGood(arr)){
                    count++;
                }
                arr[s.charAt(start++) - 'a']--;
            }
        }
        return count;
    }

    private boolean isGood(int[] arr){
        for (int i = 0; i < 26; i++){
            if (arr[i] > 1){
                return false;
            }
        }
        return true;
    }
}