1class Solution {
2    public String minRemoveToMakeValid(String s) {
3        Stack<Integer> st = new Stack<>();
4        boolean remove[] = new boolean[s.length()];
5        for(int i=0;i<s.length();i++){
6            char ch = s.charAt(i);
7            if(ch=='(') st.push(i);
8            else if(ch==')'){
9                if(!st.isEmpty()) st.pop();
10                else remove[i]=true;
11            }
12        }
13        while(!st.isEmpty()){
14            remove[st.pop()]=true;
15        }
16        StringBuilder result = new StringBuilder();
17
18        for(int i=0;i<s.length();i++){
19            if(remove[i]==false){
20                result.append(s.charAt(i));
21            }
22        }
23        return result.toString();
24
25    }
26}