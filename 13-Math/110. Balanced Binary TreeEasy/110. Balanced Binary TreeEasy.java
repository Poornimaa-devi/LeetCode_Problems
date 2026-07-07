1class Solution {
2    public long sumAndMultiply(int n) {
3        if (n == 0) return 0;
4        
5        long digitSum = 0;
6        long reversedDigits = 0;
7        int digitCount = 0;
8        
9        while (n > 0) {
10            int d = n % 10;
11            if (d != 0) {
12                digitSum += d;
13                reversedDigits = reversedDigits * 10 + d;
14                digitCount++;
15            }
16            n /= 10;
17        }
18        
19        if (digitCount == 0) return 0;
20        
21        long concatenatedNumber = 0;
22        while (reversedDigits > 0) {
23            concatenatedNumber = concatenatedNumber * 10 + (reversedDigits % 10);
24            reversedDigits /= 10;
25        }
26        
27        return concatenatedNumber * digitSum;
28    }
29}