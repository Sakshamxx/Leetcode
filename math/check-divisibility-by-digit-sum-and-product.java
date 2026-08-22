class Solution {
    public boolean checkDivisibility(int n) {
        int i = n;
        int sum = 0;
        int prod = 1;
        while ( i > 0){
            int digit = i%10;
            sum += digit;
            prod *= digit;
            i /= 10;
        }
        return (sum + prod) == n;
    }
}