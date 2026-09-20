1class Solution {
2    public int reverseDegree(String s) {
3        int sum = 0;
4        for(int i=0;i<s.length();i++){
5            char ch = s.charAt(i);
6            int idx = (26 - (ch-'a'));
7            sum +=(idx*(i+1));
8        }
9        return sum;
10    }
11}