1class Solution { 
2    public int[] maxDepthAfterSplit(String seq) { 
3        int n = seq.length();
4        int[] ans = new int[n];
5        int depth = 0;
6        for (int i = 0; i < n; ++i) {
7            if (seq.charAt(i) == '(') {
8                ++depth;
9                ans[i] = depth % 2;
10            } else {
11                ans[i] = depth % 2;
12                --depth;
13            }
14        }
15        return ans;
16    } 
17}