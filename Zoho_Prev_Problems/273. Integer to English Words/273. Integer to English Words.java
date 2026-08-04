1class Solution {
2    private static final String[] ones = {, One, Two, Three, Four, Five, Six, Seven, Eight, Nine};
3    private static final String[] below20 = {Ten, Eleven, Twelve, Thirteen, Fourteen, Fifteen, Sixteen, Seventeen, Eighteen, Nineteen};
4    private static final String[] tens = {, Ten, Twenty, Thirty, Forty, Fifty, Sixty, Seventy, Eighty, Ninety};
5
6    public String numberToWords(int num) {
7        if (num == 0) return Zero;
8        return solve(num).trim();
9    }
10
11    private String solve(int num) {
12        if (num < 10) return ones[num];
13        if (num < 20) return below20[num - 10];
14        if (num < 100) return (tens[num / 10] +   + solve(num % 10)).trim();
15        if (num < 1000) return (solve(num / 100) +  Hundred  + solve(num % 100)).trim();
16        if (num < 1000000) return (solve(num / 1000) +  Thousand  + solve(num % 1000)).trim();
17        if (num < 1000000000) return (solve(num / 1000000) +  Million  + solve(num % 1000000)).trim();
18        return (solve(num / 1000000000) +  Billion  + solve(num % 1000000000)).trim();
19    }
20}