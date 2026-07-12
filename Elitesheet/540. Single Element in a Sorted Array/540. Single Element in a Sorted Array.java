1class Solution {
2    public int singleNonDuplicate(int[] nums) {
3        int l =0;
4        int r = nums.length-1;
5        while(l<r){
6            int mid = (r+l)/2;
7            if(mid%2==1){
8                mid--;
9            }
10            if(nums[mid]==nums[mid+1]){
11                l=mid+2;
12            }else{
13                r=mid;
14            }
15        }
16        return nums[l];
17    }
18}