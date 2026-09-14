1class Solution {
2    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
3        int left = Math.max(rec1[0], rec2[0]);
4        int right = Math.min(rec1[2], rec2[2]);
5
6        int bottom = Math.max(rec1[1], rec2[1]);
7        int top = Math.min(rec1[3], rec2[3]);
8
9        return left < right && bottom < top;
10    }
11}