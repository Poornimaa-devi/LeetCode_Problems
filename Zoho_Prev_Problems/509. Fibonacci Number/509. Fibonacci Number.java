1class Solution {
2    public int fib(int n) {
3        int [] dp = new int[n+1];
4        Arrays.fill(dp,-1);
5        int res=solve(n,dp);
6        return res;
7    }
8    static int solve(int n,int[] dp){
9         if(n==0 || n==1){
10            return n;
11         }
12         if(dp[n]!=-1){
13            return dp[n];
14         }
15         return dp[n]=solve(n-1,dp) + solve(n-2,dp);
16    }
17}