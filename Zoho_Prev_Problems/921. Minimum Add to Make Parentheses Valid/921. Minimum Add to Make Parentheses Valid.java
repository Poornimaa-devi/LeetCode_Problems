1class Solution {
2    public int minAddToMakeValid(String s) {
3        int open = 0 , mismatches = 0;
4        for(char ch : s.toCharArray()){
5            if(ch == '(') open++;
6            if(ch == ')') {
7                if(open > 0) open--;
8                else mismatches++;
9            }
10        }
11        return open+mismatches;
12    }
13}