1class Solution {
2    public void sortColors(int[] nums) {
3        int n = nums.length;
4        int c0 = 0;
5        int c1 = 0;
6        int c2 = 0;
7        for(int i=0;i<n;i++){
8            if(nums[i] == 0) c0++;
9            if(nums[i] == 1) c1++;
10            if(nums[i] == 2) c2++;
11        }
12        for(int i=0;i<c0;i++){
13            nums[i] = 0;
14        }
15        for(int i=c0;i<c0+c1;i++){
16            nums[i] = 1;
17        }
18        for(int i=c0+c1;i<c0+c1+c2;i++){
19            nums[i] = 2;
20        }
21
22        return;
23    }
24}