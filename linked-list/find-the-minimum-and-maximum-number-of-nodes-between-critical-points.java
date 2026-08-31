class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int[] result = {-1, -1};
        ListNode prev = head;
        ListNode curr = head.next;
        int index = 1;
        int firstCritical = -1;
        int prevCritical = -1;
        int minDistance = Integer.MAX_VALUE;

        while (curr.next != null) {
            ListNode next = curr.next;
            boolean isCritical =
                    (curr.val > prev.val && curr.val > next.val) ||
                    (curr.val < prev.val && curr.val < next.val);

            if (isCritical) {
                if (firstCritical == -1) {
                    firstCritical = index;
                }
                if (prevCritical != -1) {
                    minDistance = Math.min(
                        minDistance,
                        index - prevCritical
                    );
                }
                prevCritical = index;
            }

            prev = curr;
            curr = curr.next;
            index++;
        }

        if (firstCritical == prevCritical) {
            return result;
        }
        int maxDistance = prevCritical - firstCritical;

        return new int[] {minDistance, maxDistance};
    }
}