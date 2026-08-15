1class Solution {
2    public int longestSubsequence(int[] nums) {
3        int result = 0;
4        boolean hasnonzero = false;
5        for(int i=0;i<nums.length;i++){
6            if(nums[i]!=0) hasnonzero = true;
7            result^=nums[i];
8
9        }
10        if(!hasnonzero) return 0;
11        if(result>0) return nums.length;
12        else return nums.length-1;
13    }
14}