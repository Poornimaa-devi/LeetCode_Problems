1class Solution {
2    public int climbStairs(int n) {
3        if(n<=2) return n;
4        int prev1 = 1;
5        int prev2 = 2;
6        int res = 0;
7        for(int i=3;i<=n;i++){
8            res = prev1 + prev2;
9            prev1 = prev2;
10            prev2 = res;
11        }
12        return prev2;
13    }
14}