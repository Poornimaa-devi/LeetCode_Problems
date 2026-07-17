1class Solution {
2    public int[][] transpose(int[][] matrix) {
3        int r = matrix.length;
4        int c = matrix[0].length;
5        int[][] arr = new int[c][r];
6        for(int i=0;i<r;i++){
7            for(int j=0;j<c;j++){
8                arr[j][i]= matrix[i][j];
9            }
10        }
11        return arr;
12    }
13}