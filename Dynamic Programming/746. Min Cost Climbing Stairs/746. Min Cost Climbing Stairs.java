1class Solution {
2    public int minCostClimbingStairs(int[] cost) {
3        int n=cost.length;
4        int dp[] = new int[n+2];
5        dp[n]=0;
6        dp[n+1]=0;
7        for(int i=n-1;i>=0;i--){
8            dp[i] = cost[i]+Math.min(dp[i+1],dp[i+2]);
9        }
10        return Math.min(dp[0],dp[1]);
11    }
12}