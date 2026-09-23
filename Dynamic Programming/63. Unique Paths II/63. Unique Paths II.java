1class Solution {
2    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
3        int m = obstacleGrid.length;
4        int n = obstacleGrid[0].length;
5        if(obstacleGrid[0][0]==1) return 0;
6        int[][] dp = new int[m][n];
7        for(int i=0;i<m;i++){
8            if (obstacleGrid[i][0] == 1) break;
9            dp[i][0]=1;
10        }
11        for(int i=0;i<n;i++){
12            if (obstacleGrid[0][i] == 1) break;
13            dp[0][i]=1;
14        }
15        for(int i=1;i<m;i++){
16            for(int j=1;j<n;j++){
17                if(obstacleGrid[i][j]==1) dp[i][j]=0;
18                else {
19                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
20                }
21            }
22        }
23        return dp[m-1][n-1];
24    }
25}