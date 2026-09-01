1class Solution {
2    public int missingNumber(int[] nums) {
3        int n = nums.length;
4        int expectedsum = n*(n+1)/2;
5        int actual = 0;
6        for(int num:nums){
7            actual += num;
8        }
9        return expectedsum - actual;
10    }
11}