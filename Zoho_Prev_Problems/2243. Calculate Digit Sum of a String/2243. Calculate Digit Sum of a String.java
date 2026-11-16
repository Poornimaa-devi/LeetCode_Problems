1class Solution {
2    public String digitSum(String s, int k) {
3        while (s.length() > k) {
4            StringBuilder next = new StringBuilder();
5            for (int i = 0; i < s.length(); i += k) {
6                int sum = 0;
7                for (int j = i; j < s.length() && j < i + k; j++) {
8                    sum += s.charAt(j) - '0';
9                }
10                next.append(sum);
11            }
12            s = next.toString();
13        }
14        return s;
15    }
16}