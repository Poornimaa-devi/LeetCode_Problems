1class Solution {
2    public int largestRectangleArea(int[] heights) {
3        Stack<Integer> st = new Stack<>();
4        int maxArea = 0;
5
6        for(int i=0;i<heights.length;i++){
7            while(!st.isEmpty() && heights[i]<heights[st.peek()]){
8                int height = heights[st.pop()];
9                int width;
10                if(st.isEmpty()) width=i;
11                else width= i - st.peek() - 1;
12                int area = height*width;
13                maxArea = Math.max(maxArea,area);
14            }
15            st.push(i);
16        }
17
18        while(!st.isEmpty()){
19            int height = heights[st.pop()];
20            int width;
21            if(st.isEmpty()) width = heights.length;
22            else width = heights.length - st.peek() - 1;
23            int area = height*width;
24            maxArea = Math.max(maxArea,area);
25        }
26        return maxArea;
27    }
28}