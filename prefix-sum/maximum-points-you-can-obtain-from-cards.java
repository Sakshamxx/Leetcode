class Solution {
    public int maxScore(int[] card, int k) {
     int n = card.length;
     int j = n-1;   
     int sum = 0 ;
     int count = 0;
     

    for(int i = 0 ; i < k ; i++){
        sum += card[i];
    }

    int max = sum;

    while( k > 0){
        sum -= card[--k];
        sum +=card[j--];
        if(sum > max){
            max = sum;
        }
    }
    return max;
    }
}