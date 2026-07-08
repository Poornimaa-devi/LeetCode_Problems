1class Solution {
2    public boolean isPalindrome(String s) {
3        if(s.isEmpty()){
4            return true;
5        }
6        int start=0;
7        int last=s.length()-1;
8        while(start<last){
9            char currfirst = s.charAt(start);
10            char currlast = s.charAt(last);
11            if(!Character.isLetterOrDigit(currfirst)){
12                start++;
13            }else if(!Character.isLetterOrDigit(currlast)){
14                last--;
15            }else{
16                if(Character.toLowerCase(currfirst)!=Character.toLowerCase(currlast)){
17                      return false;
18                }
19                start++;
20                last--;
21            }
22        }
23        return true;
24    }
25}