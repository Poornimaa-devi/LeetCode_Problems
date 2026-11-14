1class Solution {
2    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
3        int n = nums.size();
4        int ans = Integer.MAX_VALUE;
5        for (int i = 0; i < n; i++) {
6            int sum = 0;
7            for (int j = i; j < n; j++) {
8                sum += nums.get(j);
9                int len = j - i + 1;
10                if (len >= l && len <= r && sum > 0) {
11                    ans = Math.min(ans, sum);
12                }
13            }
14        }
15        return ans == Integer.MAX_VALUE ? -1 : ans;
16    }
17}