1class Solution {
2    public boolean doesAliceWin(String s) {
3        for(char ch : s.toCharArray()){
4            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
5                return true;
6            }
7        }
8        return false;
9    }
10}