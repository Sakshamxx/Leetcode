class Solution {
    public int fib(int n) {
        if ( n==0 ){
            return 0;
        }else if (n==1){
            return 1;
        }
        int first = 0;
        int second = 1;

        for (int i =1; i<=n; i++){
            int third = first + second;

            first = second;
            second = third;
        }
        return first;
    }
}