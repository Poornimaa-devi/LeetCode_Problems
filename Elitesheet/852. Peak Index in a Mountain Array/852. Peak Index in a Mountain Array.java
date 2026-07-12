1class Solution {
2    public int peakIndexInMountainArray(int[] arr) {
3        int left = 0;
4        int right = arr.length-1;
5        while(left<right){
6            int mid = left+(right-left)/2;
7            if(arr[mid+1]<arr[mid]) right=mid;
8            else{
9                left=mid+1;
10            }
11        }
12        return left;
13    }
14}