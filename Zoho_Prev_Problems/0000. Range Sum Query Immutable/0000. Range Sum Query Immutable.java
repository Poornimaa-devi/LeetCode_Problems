1class NumArray {
2    public int[] prefixsum;
3    public NumArray(int[] nums) {
4        prefixsum = new int[nums.length];
5        prefixsum[0]=nums[0];
6        for(int i=1;i<nums.length;i++){
7            prefixsum[i]+=prefixsum[i-1]+nums[i];
8        }
9    }
10    
11    public int sumRange(int left, int right) {
12        if(left==0) return prefixsum[right];
13        return prefixsum[right]-prefixsum[left-1];
14    }
15}
16
17/**
18 * Your NumArray object will be instantiated and called as such:
19 * NumArray obj = new NumArray(nums);
20 * int param_1 = obj.sumRange(left,right);
21 */