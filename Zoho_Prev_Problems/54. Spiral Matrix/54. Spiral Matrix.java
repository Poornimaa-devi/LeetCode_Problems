1class Solution {
2    public List<Integer> spiralOrder(int[][] matrix) {
3        List<Integer> list = new ArrayList<>();
4        int top=0;
5        int bottom=matrix.length-1;
6        int left=0;
7        int right=matrix[0].length-1;
8        while(top<=bottom && left<=right){
9            for(int i=left;i<=right;i++){
10                list.add(matrix[top][i]);
11            }
12            top++;
13            for(int i=top;i<=bottom;i++){
14                list.add(matrix[i][right]);
15            }
16            right--;
17            if(top<=bottom){
18            for(int i=right;i>=left;i--){
19                list.add(matrix[bottom][i]);
20            }
21            bottom--;
22            }
23
24            if(left<=right){
25                for(int i=bottom;i>=top;i--){
26                    list.add(matrix[i][left]);
27                }
28                left++;
29            }
30        }
31        return list;
32    }
33}