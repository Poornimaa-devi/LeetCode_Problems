1class Solution {
2    public int scoreOfParentheses(String s) {
3        Stack<Integer> stack = new Stack<>();
4        stack.push(0);
5        for(int i=0;i<s.length();i++){
6            char ch = s.charAt(i);
7            if(ch=='(') stack.push(0);
8            else{
9                int current = stack.pop();
10                int score;
11                if(s.charAt(i-1)=='('){
12                    score=1;
13                }else{
14                    score = 2*current;
15                }
16                int prev = stack.pop();
17                stack.push(prev+score);
18            }
19        }
20        return stack.peek();
21    }
22}