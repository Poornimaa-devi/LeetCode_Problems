1class Solution {
2    public int majorityElement(int[] nums) {
3        int candidate = nums[0];
4        int count = 0;
5        
6        for (int num : nums) {
7            if (count == 0) {
8                candidate = num;
9            }
10            count += (num == candidate) ? 1 : -1;
11        }
12        
13        return candidate;
14    }
15}