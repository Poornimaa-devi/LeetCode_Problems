1class Solution {
2    public int maxDepth(String s) {
3        int maxdepth=0;
4        int depth = 0;
5        for(char ch : s.toCharArray()){
6            if(ch=='(') {
7                depth++;
8                maxdepth = Math.max(maxdepth,depth);
9            }
10            if(ch==')') depth--;
11        }
12        return maxdepth;
13    }
14}