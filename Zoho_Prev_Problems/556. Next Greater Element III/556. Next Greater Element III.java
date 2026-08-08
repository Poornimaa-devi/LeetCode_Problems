1class Solution {
2    public int nextGreaterElement(int n) {
3        char digits[] = String.valueOf(n).toCharArray();
4        int i = digits.length-2;
5        while(i>=0 && digits[i]>=digits[i+1]){
6            i--;
7        }
8        if(i==-1) return -1;
9
10        int nextint = digits.length-1;
11        while(digits[nextint] <= digits[i]){
12           nextint--;
13        }
14        char temp = digits[i];
15        digits[i] = digits[nextint];
16        digits[nextint] = temp;
17
18        int left = i+1;
19        int right = digits.length-1;
20        while(left<right){
21            char temp1 = digits[left];
22            digits[left] = digits[right];
23            digits[right] = temp1;
24            left++;
25            right--;
26        }
27        long result = Long.parseLong(new String(digits));
28        if(result > Integer.MAX_VALUE){
29            return -1;
30        }else{
31            return (int) result;
32        }
33    }
34}