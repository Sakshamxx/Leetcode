class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }

        double power = Math.log(n) / Math.log(3);
        int x = (int) power;

        return Math.pow(3, x) == n;
    }
}