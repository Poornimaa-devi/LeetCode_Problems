1class Solution {
2    public boolean searchMatrix(int[][] matrix, int target) {
3        int rows = matrix.length;
4        int cols = matrix[0].length;
5        int low = 0;
6        int high = rows*cols-1;
7        while(low<=high){
8            int mid = (low+high)/2;
9            int r = mid/cols;
10            int c = mid%cols;
11            int curr = matrix[r][c];
12            if(curr==target) return true;
13            if(curr<target){
14                low=mid+1;
15            }else{
16                high=mid-1;
17            }
18        }
19        return false;
20    }
21}