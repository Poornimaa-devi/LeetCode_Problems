1class Solution {
2    public int uniquePaths(int m, int n) {
3        int dp[][] = new int[m+1][n+1];
4        for(int i=0;i<m;i++){
5            dp[i][0]=1;
6        }
7        for(int i=0;i<n;i++){
8            dp[0][i]=1;
9        }
10        for(int i=1;i<m;i++){
11            for(int j=1;j<n;j++){
12                dp[i][j]=dp[i-1][j]+dp[i][j-1];
13            }
14        }
15        return dp[m-1][n-1];
16    }
17}