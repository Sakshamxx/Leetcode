class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean xOverlap = rec1[0] < rec2[2] && rec2[0] < rec1[2];
        boolean yOverlap = rec1[1] < rec2[3] && rec2[1] < rec1[3];
        return xOverlap && yOverlap;
    }
}