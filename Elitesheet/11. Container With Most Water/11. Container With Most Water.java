1class Solution {
2    public int maxArea(int[] height) {
3        int left=0;
4        int right=height.length-1;
5        int maxarea=0;
6        while(left<right){
7            int minheight = Math.min(height[left],height[right]);
8            int width = right-left;
9            int area = width*minheight;
10            maxarea = Math.max(area,maxarea);
11            if(height[left]<height[right]){
12                left++;
13            }else{
14                right--;
15            }
16        }
17        return maxarea;
18    }
19}