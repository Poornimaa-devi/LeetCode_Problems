1class Solution {
2    public int maximalRectangle(char[][] matrix) {
3        if(matrix.length==0) return 0;
4        int row = matrix.length;
5        int col = matrix[0].length;
6        int maxArea = 0;
7        int heights [] = new int[col];
8        for(int i=0;i<row;i++){
9            for(int j=0;j<col;j++){
10                if(matrix[i][j]=='1'){
11                    heights[j]++;
12                }else{
13                    heights[j]=0;
14                }
15            }
16            maxArea = Math.max(maxArea,largerRectangularArea(heights));
17        }
18        return maxArea;
19    }
20
21    public static int largerRectangularArea(int heights[]){
22        Stack<Integer> st = new Stack<>();
23        int max = 0;
24        for(int i=0;i<heights.length;i++){
25            while (!st.isEmpty() && heights[i]<heights[st.peek()]){
26                int height = heights[st.pop()];
27                int width;
28                if(st.isEmpty()) width = i;
29                else width = i - st.peek() - 1;
30                int area = height*width;
31                max = Math.max(max,area);
32            }
33            st.push(i);
34        }
35
36        while(!st.isEmpty()){
37            int height = heights[st.pop()];
38            int width;
39            if(st.isEmpty()) width = heights.length;
40            else width = heights.length - st.peek() - 1;
41            int area = height*width;
42            max = Math.max(max,area);
43        }
44        return max;
45    }
46}