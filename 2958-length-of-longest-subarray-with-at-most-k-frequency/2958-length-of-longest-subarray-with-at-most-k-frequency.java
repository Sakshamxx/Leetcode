class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int maxlen = 0;

        for (int right = 0; right < nums.length; right++) {
            int ele = nums[right];

            // Add current element
            map.put(ele, map.getOrDefault(ele, 0) + 1);

            // Shrink while invalid
            while (map.get(ele) > k) {
                int frontEle = nums[left];
                map.put(frontEle, map.get(frontEle) - 1);
                left++;
            }
            // Current window is valid
            maxlen = Math.max(maxlen, right - left + 1);
        }
        return maxlen;
    }
}