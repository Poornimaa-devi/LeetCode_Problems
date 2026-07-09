1class Solution {
2    public double myPow(double x, int n) {
3        long exp=n;
4        if(exp<0){
5            x=1/x;
6            exp = -exp;
7        }
8        double ans = 1;
9        while(exp>0){
10            if((exp&1)==1){
11                ans *= x;
12            }
13            x*=x;
14            exp>>=1;
15        }
16        return ans;
17    }
18}