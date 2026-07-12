1class Solution {
2    public int[] maxSlidingWindow(int[] nums, int k) {
3        int pref[] = new int[nums.length];
4        int suff[] = new int[nums.length];
5
6        for(int i=0;i<nums.length;i++){
7            if(i%k==0) pref[i]=nums[i];
8            else{
9                pref[i]=Math.max(pref[i-1],nums[i]);
10            }
11        }
12
13        suff[nums.length-1]=nums[nums.length-1];
14        for(int i=nums.length-2;i>=0;i--){
15            if((i+1)%k==0){
16                suff[i]=nums[i];
17            }else{
18                suff[i]=Math.max(suff[i+1],nums[i]);
19            }
20        }
21
22        int ans[] = new int[nums.length-k+1];
23        for(int i=0;i<ans.length;i++){
24            ans[i]=Math.max(suff[i],pref[i+k-1]);
25        }
26        return ans;
27    }
28}