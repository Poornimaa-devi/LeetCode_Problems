1class Solution {
2    public boolean predictTheWinner(int[] nums) {
3        int n = nums.length;
4        if (n % 2 == 0) return true;
5        
6        int[] dp = nums.clone();
7        for (int i = n - 2; i >= 0; --i) {
8            for (int j = i + 1; j < n; ++j) {
9                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
10            }
11        }
12        return dp[n - 1] >= 0;
13    }
14}