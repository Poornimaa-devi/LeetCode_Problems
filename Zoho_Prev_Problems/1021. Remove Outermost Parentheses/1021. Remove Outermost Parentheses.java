1class Solution {
2    public String removeOuterParentheses(String s) {
3        StringBuilder sb = new StringBuilder();
4        int bal = 0;
5        for(char ch : s.toCharArray()){
6            if(ch=='('){
7                if(bal > 0) sb.append(ch);
8                bal++;
9            }else{
10                bal--;
11                if(bal>0) sb.append(ch);
12            }
13        }
14        return sb.toString();
15    }
16}