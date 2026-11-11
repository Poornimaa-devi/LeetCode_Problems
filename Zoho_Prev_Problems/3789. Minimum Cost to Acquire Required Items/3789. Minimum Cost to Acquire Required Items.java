1class Solution {
2    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
3        long c1 = cost1, c2 = cost2, cb = costBoth;
4        long n1 = need1, n2 = need2;
5        long pairs = Math.min(n1, n2);
6        long costPairs = pairs * Math.min(cb, c1 + c2);
7        long rem1 = n1 - pairs;
8        long rem2 = n2 - pairs;
9        long costRem = rem1 * Math.min(c1, cb) + rem2 * Math.min(c2, cb);
10        return costPairs + costRem;
11    }
12}