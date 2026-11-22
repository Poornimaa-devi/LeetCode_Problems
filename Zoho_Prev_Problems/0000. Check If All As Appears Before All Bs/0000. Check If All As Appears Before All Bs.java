1class Solution {
2    public boolean checkString(String s) {
3        boolean seenB = false;
4        for (char c : s.toCharArray()) {
5            if (c == 'b') {
6                seenB = true;
7            } else if (seenB) {
8                return false;
9            }
10        }
11        return true;
12    }
13}