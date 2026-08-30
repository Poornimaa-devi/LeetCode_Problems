1class Solution {
2    public int change(int amount, int[] coins) {
3        int dp[] = new int[amount+1];
4        dp[0]=1;
5        for(int coin : coins){
6            for(int i=coin;i<=amount;i++){
7                dp[i]+=dp[i-coin];
8            }
9        }
10        return dp[amount];
11    }
12}