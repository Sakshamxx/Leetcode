class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int linearSum = kadenes_Algo(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum = sum + nums[i];
            nums[i] = nums[i]*(-1);
        }
        int mid = kadenes_Algo(nums);
        int Circular_Max = sum + mid;
        if (Circular_Max == 0){
            return linearSum;
        }
        return Math.max(Circular_Max, linearSum);
    }

    public static int kadenes_Algo(int[] arr){
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum+=arr[i];
            ans = Math.max(ans, sum);
            if (sum < 0){
                sum = 0;
            }
        }
        return ans;
    }
}