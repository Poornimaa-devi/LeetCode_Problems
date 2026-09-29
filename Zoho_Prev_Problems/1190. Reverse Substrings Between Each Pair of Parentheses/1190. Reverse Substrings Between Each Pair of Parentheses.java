1class Solution {
2    public String reverseParentheses(String s) {
3        Stack<String> stack = new Stack<>();
4        StringBuilder current = new StringBuilder();
5        for(char ch : s.toCharArray()){
6            if(ch == '('){
7                stack.push(current.toString());
8                current.setLength(0);
9            }else if(ch == ')'){
10                current.reverse();
11                current.insert(0,stack.pop());
12            }else{
13                current.append(ch);
14            }
15        }
16        return current.toString();
17    }
18}