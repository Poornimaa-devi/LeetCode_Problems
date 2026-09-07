1class Solution {
2    public int rob(int[] nums) {
3        int n = nums.length;
4        if(n==1) return nums[0];
5        int dp[] = new int[n];
6        dp[0]=nums[0];
7        dp[1]=Math.max(nums[1],nums[0]);
8        for(int i=2;i<n;i++){
9            int rob = nums[i] + dp[i-2];
10            int skip = dp[i-1];
11            dp[i] = Math.max(skip,rob);
12        }
13        return dp[n-1];
14    }
15}