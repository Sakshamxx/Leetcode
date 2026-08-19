class Solution {
    public boolean isPowerOfThree(int n) {
        double power = Math.log(n)/ Math.log(3);
        int x = (int) power;
        return n > 0 && Math.pow(3,x) == n;
    }
}