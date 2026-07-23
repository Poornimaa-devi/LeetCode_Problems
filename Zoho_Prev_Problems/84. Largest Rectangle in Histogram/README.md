<h2><a href="https://leetcode.com/problems/largest-rectangle-in-histogram">84. Largest Rectangle in Histogram</a></h2>

<p>Given an array of integers <code>heights</code> representing the histogram's bar height where the width of each bar is <code>1</code>, return <em>the area of the largest rectangle in the histogram</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/histogram.jpg" style="width: 522px; height: 242px;">
<pre><strong>Input:</strong> heights = [2,1,5,6,2,3]
<strong>Output:</strong> 10
<strong>Explanation:</strong> The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2021/01/04/histogram-1.jpg" style="width: 202px; height: 362px;">
<pre><strong>Input:</strong> heights = [2,4]
<strong>Output:</strong> 4
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= heights.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= heights[i] &lt;= 10<sup>4</sup></code></li>
</ul>


---

# 🛍️ Largest-Rectangle-in-Histogram | Explained

## Approach 1: Stack-Based Approach
### Intuition
The core idea behind this approach is to use a stack to keep track of the indices of the histogram bars. We start by iterating over the histogram bars from left to right, and for each bar, we check if the stack is empty or if the current bar is higher than the bar at the top of the stack. If the stack is empty or the current bar is higher, we push the current index onto the stack. If the current bar is lower than the bar at the top of the stack, we calculate the area of the rectangle with the bar at the top of the stack as the smallest bar and update the maximum area if necessary. We repeat this process until we have iterated over all the bars.

This approach works because the stack allows us to efficiently keep track of the bars that are still "active" (i.e., have not been used to calculate an area yet). By using the stack to store the indices of the bars, we can easily calculate the width of the rectangle with the bar at the top of the stack as the smallest bar.

### Algorithm Visualized
```mermaid
graph LR
    A[Histogram Bar] -->|Push Index|> B(Stack)
    B -->|Pop Index|> C[Calculate Area]
    C -->|Update Max Area|> D
    D -->|Continue Iteration|> A
```

### Approach
The high-level logic flow of this approach is as follows:
- Initialize an empty stack and a variable to store the maximum area.
- Iterate over the histogram bars from left to right.
- For each bar, check if the stack is empty or if the current bar is higher than the bar at the top of the stack.
- If the stack is empty or the current bar is higher, push the current index onto the stack.
- If the current bar is lower than the bar at the top of the stack, calculate the area of the rectangle with the bar at the top of the stack as the smallest bar and update the maximum area if necessary.
- After iterating over all the bars, pop any remaining indices from the stack and calculate the area of the rectangle with the bar at the top of the stack as the smallest bar.

### Detailed Code Analysis
The code is divided into two main parts: the iteration over the histogram bars and the calculation of the area after the iteration is complete.

The iteration over the histogram bars starts at line 6: `for(int i=0;i<heights.length;i++)`. For each bar, we check if the stack is empty or if the current bar is higher than the bar at the top of the stack using the condition `while(!st.isEmpty() && heights[i]<heights[st.peek()])`. If this condition is true, we calculate the area of the rectangle with the bar at the top of the stack as the smallest bar.

The calculation of the area is done in the following lines:
- `int height = heights[st.pop()];` gets the height of the bar at the top of the stack.
- `int width;` declares a variable to store the width of the rectangle.
- `if(st.isEmpty()) width=i;` sets the width to the current index if the stack is empty.
- `else width= i - st.peek() - 1;` sets the width to the difference between the current index and the index at the top of the stack minus 1 if the stack is not empty.
- `int area = height*width;` calculates the area of the rectangle.
- `maxArea = Math.max(maxArea,area);` updates the maximum area if the calculated area is larger.

After the iteration over the histogram bars is complete, we pop any remaining indices from the stack and calculate the area of the rectangle with the bar at the top of the stack as the smallest bar using the following lines:
- `while(!st.isEmpty())` checks if the stack is not empty.
- `int height = heights[st.pop()];` gets the height of the bar at the top of the stack.
- `int width;` declares a variable to store the width of the rectangle.
- `if(st.isEmpty()) width = heights.length;` sets the width to the length of the histogram if the stack is empty.
- `else width = heights.length - st.peek() - 1;` sets the width to the difference between the length of the histogram and the index at the top of the stack minus 1 if the stack is not empty.
- `int area = height*width;` calculates the area of the rectangle.
- `maxArea = Math.max(maxArea,area);` updates the maximum area if the calculated area is larger.

### Code
```java
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty() && heights[i]<heights[st.peek()]){
                int height = heights[st.pop()];
                int width;
                if(st.isEmpty()) width=i;
                else width= i - st.peek() - 1;
                int area = height*width;
                maxArea = Math.max(maxArea,area);
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int height = heights[st.pop()];
            int width;
            if(st.isEmpty()) width = heights.length;
            else width = heights.length - st.peek() - 1;
            int area = height*width;
            maxArea = Math.max(maxArea,area);
        }
        return maxArea;
    }
}
```

### Complexity
- **Time:** O(n), where n is the number of histogram bars. This is because we are iterating over the histogram bars once and performing a constant amount of work for each bar.
- **Space:** O(n), where n is the number of histogram bars. This is because in the worst case, we may need to store the indices of all the histogram bars in the stack.