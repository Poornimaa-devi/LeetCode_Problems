1class Solution {
2    public boolean isValid(String s) {
3        Stack<Character> st = new Stack<>();
4        for(char ch : s.toCharArray()){
5            if(ch=='(' || ch=='{' || ch=='[') st.push(ch);
6            else {
7                if(st.isEmpty()) return false;
8                char top = st.pop();
9                if(ch==')' && top!='(' || ch==']' && top!='[' || ch=='}' && top!='{')
10    
11                return false;
12            }
13        }
14        return st.isEmpty();
15    }
16}