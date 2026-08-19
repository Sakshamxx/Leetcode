class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n<=0){
            return false;
        }
        double power = Math.log(n)/Math.log(2);
        int x = (int) power;

        return Math.pow(2,x) == n; 
    }
}