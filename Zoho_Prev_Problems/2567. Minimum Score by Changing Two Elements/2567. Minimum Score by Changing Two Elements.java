1class Solution {
2    public int minimizeSum(int[] nums) {
3        int s0 = Integer.MAX_VALUE, s1 = Integer.MAX_VALUE, s2 = Integer.MAX_VALUE;
4        int l0 = 0, l1 = 0, l2 = 0;
5        for (int x : nums) {
6            if (x < s0) {
7                s2 = s1;
8                s1 = s0;
9                s0 = x;
10            } else if (x < s1) {
11                s2 = s1;
12                s1 = x;
13            } else if (x < s2) {
14                s2 = x;
15            }
16            if (x > l0) {
17                l2 = l1;
18                l1 = l0;
19                l0 = x;
20            } else if (x > l1) {
21                l2 = l1;
22                l1 = x;
23            } else if (x > l2) {
24                l2 = x;
25            }
26        }
27        return Math.min(l0 - s2, Math.min(l2 - s0, l1 - s1));
28    }
29}