1class Solution {
2    public void nextPermutation(int[] nums) {
3        int i = nums.length-2;
4        while(i>=0 && nums[i]>=nums[i+1]){
5            i--;
6        }
7        if(i>=0){
8            int j = nums.length-1;
9            while (nums[j] <= nums[i]) {
10              j--;
11            }
12        
13            int temp = nums[i];
14            nums[i] = nums[j];
15            nums[j] = temp;
16        }
17        int left = i+1;
18            int right = nums.length-1;
19            while(left<right){
20                int temp = nums[left];
21                nums[left] = nums[right];
22                nums[right] = temp;
23
24                left++;
25                right--;
26            }
27    }
28}