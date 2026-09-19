1class Solution {
2    public boolean checkOverlap(int radius, int xCenter, int yCenter,
3                                int x1, int y1, int x2, int y2) {
4
5        int x = Math.max(x1, Math.min(xCenter, x2)) - xCenter;
6        int y = Math.max(y1, Math.min(yCenter, y2)) - yCenter;
7
8        return x * x + y * y <= radius * radius;
9    }
10}