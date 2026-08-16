1class Solution {
2    public String convertToTitle(int columnNumber) {
3        StringBuilder result = new StringBuilder();
4        while(columnNumber > 0){
5            columnNumber--;
6            int temp = columnNumber%26;
7            result.append((char)('A'+temp));
8            columnNumber/=26;
9        }
10        return result.reverse().toString();
11    }
12}