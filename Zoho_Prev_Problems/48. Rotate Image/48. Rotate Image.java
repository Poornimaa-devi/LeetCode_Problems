1class Solution {
2    public void rotate(int[][] matrix) {
3        int n = matrix.length;
4        int m = matrix[0].length;
5        for(int i=0;i<n;i++){
6            for(int j=i+1;j<n;j++){
7                int temp= matrix[i][j];
8                matrix[i][j]=matrix[j][i];
9                matrix[j][i]=temp;
10            }
11        }
12
13        for(int k=0;k<n;k++){
14            int i=0,j=n-1;
15            while(i<j){
16                int temp = matrix[k][i];
17                matrix[k][i]=matrix[k][j];
18                matrix[k][j]=temp;
19                i++;
20                j--;
21            }
22        }
23    }
24}