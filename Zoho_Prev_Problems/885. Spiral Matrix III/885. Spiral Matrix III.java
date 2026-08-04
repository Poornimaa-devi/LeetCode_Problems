1class Solution {
2    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
3        int[][] ans = new int [rows*cols][2];
4        int r = rStart;
5        int c = cStart;
6        ans[0][0] = rStart;
7        ans[0][1] = cStart;
8        int index = 1;
9        int steps = 1;
10        while(index < rows*cols){
11            for(int i=0;i<steps;i++){
12                c++;
13                if(r>=0 && c>=0 && r<rows && c<cols){
14                    ans[index][0]=r;
15                    ans[index][1]=c;
16                    index++;
17                }
18            }
19            for(int i=0;i<steps;i++){
20                r++;
21                if(r>=0 && c>=0 && r<rows && c<cols){
22                    ans[index][0]=r;
23                    ans[index][1]=c;
24                    index++;
25                }
26            }
27            steps++;
28            for(int i=0;i<steps;i++){
29                c--;
30                if(r>=0 && c>=0 && r < rows && c<cols){
31                    ans[index][0]=r;
32                    ans[index][1]=c;
33                    index++;
34                }
35            }
36            for(int i=0;i<steps;i++){
37                r--;
38                if(r>=0 && c>=0 && r < rows && c<cols){
39                    ans[index][0]=r;
40                    ans[index][1]=c;
41                    index++;
42                }
43            }
44            steps++;
45        }
46        return ans;
47    }
48}