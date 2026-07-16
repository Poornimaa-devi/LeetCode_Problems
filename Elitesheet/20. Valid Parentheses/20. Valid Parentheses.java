1class Solution {
2    public boolean isValid(String s) {
3        Stack<Character> stack = new Stack<>();
4        for(char c: s.toCharArray()){
5             if(c=='(' || c=='{' ||c=='[')
6                 stack.push(c);
7              else{
8                if(stack.isEmpty())
9                     return false;
10                char top = stack.pop();
11                if(c==')' && top!='(' || c=='}' && top!='{' || c==']' && top!='[' )
12                return false;
13              }
14        }
15        return stack.isEmpty();
16    }
17}