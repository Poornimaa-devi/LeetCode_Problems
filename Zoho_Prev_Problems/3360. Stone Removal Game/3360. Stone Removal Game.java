1class Solution {
2    public boolean canAliceWin(int n) {
3        int remove = 10;
4        boolean aliceTurn = true;
5        while (n >= remove) {
6            n -= remove;
7            remove--;
8            aliceTurn = !aliceTurn;
9        }
10        return !aliceTurn;
11    }
12}