1class Solution {
2    public List<Integer> findCoins(int[] numWays) {
3        int n = numWays.length;
4        int[] dp = new int[n + 1];
5        dp[0] = 1;
6        List<Integer> coins = new ArrayList<>();
7
8        for (int i = 1; i <= n; i++) {
9            int target = numWays[i - 1];
10
11            if (dp[i] == target) {
12                continue;
13            } else if (dp[i] + 1 == target) {
14                coins.add(i);
15                for (int j = i; j <= n; j++) {
16                    dp[j] += dp[j - i];
17                }
18            } else {
19                return new ArrayList<>();
20            }
21        }
22
23        return coins;
24    }
25}