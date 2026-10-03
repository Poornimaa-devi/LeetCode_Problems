1class Solution {
2    public int longestValidParentheses(String s) {
3        Stack<Integer> stack = new Stack<>();
4        stack.push(-1);
5        int maxLength = 0;
6        for (int i = 0; i < s.length(); i++) {
7            if (s.charAt(i) == '(') {
8                stack.push(i);
9            } else {
10                stack.pop();
11                if (stack.isEmpty()) {
12                    stack.push(i);
13                } else {
14                    int length = i - stack.peek();
15                    maxLength = Math.max(maxLength, length);
16                }
17            }
18        }
19        return maxLength;
20    }
21}