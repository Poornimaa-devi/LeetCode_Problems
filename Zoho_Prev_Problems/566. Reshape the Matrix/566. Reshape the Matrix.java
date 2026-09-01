1class Solution {
2    public int[][] matrixReshape(int[][] mat, int r, int c) {
3        int m = mat.length;
4        int n = mat[0].length;
5        if(m*n != r*c) return mat;
6        int idx = 0;
7        int[][] result = new int[r][c];
8        for(int i=0;i<m;i++){
9            for(int j=0;j<n;j++){
10                result[idx/c][idx%c]=mat[i][j];
11                idx++;
12            }
13        }
14        return result;
15    }
16}