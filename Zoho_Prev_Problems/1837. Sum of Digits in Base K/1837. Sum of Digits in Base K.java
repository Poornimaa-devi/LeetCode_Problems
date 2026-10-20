1class Solution {
2    public int sumBase(int n, int k) {
3        int sum=0;
4        while(n!=0){
5            sum+=n%k;
6            n/=k;
7        }
8        return sum;
9    }
10}