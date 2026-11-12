1class Solution {
2    public int longestMonotonicSubarray(int[] nums) {
3        int n = nums.length;
4        int maxLen = 1, inc = 1, dec = 1;
5        for (int i = 1; i < n; i++) {
6            if (nums[i] > nums[i - 1]) {
7                inc++;
8                dec = 1;
9            } else if (nums[i] < nums[i - 1]) {
10                dec++;
11                inc = 1;
12            } else {
13                inc = 1;
14                dec = 1;
15            }
16            maxLen = Math.max(maxLen, Math.max(inc, dec));
17        }
18        return maxLen;
19    }
20}