class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int lo = 0;
        int hi = arr.length -1;
        while(lo<=hi){
            int mid = (hi-lo)/2 + lo;
            if (arr[mid] < arr[mid + 1]){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }
        }
        return lo;
    }
}