class Solution {
    public int countCommas(int n) {
        int digit = 0;
        while (n > 999){
            n -= 1;
            digit++;
        }
        return digit;
    }
}