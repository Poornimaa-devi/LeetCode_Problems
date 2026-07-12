1class Solution {
2    public int search(int[] nums, int target) {
3        for(int i=0;i<nums.length;i++){
4            if(nums[i]==target) return i;
5        }
6        return -1;
7    }
8}