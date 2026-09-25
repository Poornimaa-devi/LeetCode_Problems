1class Solution {
2    public int coinChange(int[] coins, int amount) {
3        int dp[] = new int[amount+1];
4        Arrays.fill(dp,amount+1);
5        dp[0]=0;
6        for(int i=1;i<=amount;i++){
7            for(int coin : coins){
8                if(coin <=i){
9                    dp[i]=Math.min(dp[i],dp[i-coin]+1);
10                }
11            }
12        }
13        return dp[amount]>amount ? -1 : dp[amount];
14    }
15}