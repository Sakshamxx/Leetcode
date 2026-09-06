class Solution {
    public int numDistinct(String s, String t) {
        int m=s.length();
        int n=t.length();
        int[] curr=new int[n+1];curr[n]=1;
        for(int i=m-1;i>=0;i--){
            for(int j=0;j<n;j++){
                if(s.charAt(i)==t.charAt(j)){
                    curr[j]=curr[j+1]+curr[j];
                }else{
                    curr[j]=curr[j];
                }
            }
        }
        return curr[0];
    }
}