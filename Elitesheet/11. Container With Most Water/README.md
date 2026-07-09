<h2><a href="https://leetcode.com/problems/container-with-most-water">11. Container With Most Water</a></h2>

<p>You are given an integer array <code>height</code> of length <code>n</code>. There are <code>n</code> vertical lines drawn such that the two endpoints of the <code>i<sup>th</sup></code> line are <code>(i, 0)</code> and <code>(i, height[i])</code>.</p>

<p>Find two lines that together with the x-axis form a container, such that the container contains the most water.</p>

<p>Return <em>the maximum amount of water a container can store</em>.</p>

<p><strong>Notice</strong> that you may not slant the container.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/17/question_11.jpg" style="width: 600px; height: 287px;">
<pre><strong>Input:</strong> height = [1,8,6,2,5,4,8,3,7]
<strong>Output:</strong> 49
<strong>Explanation:</strong> The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> height = [1,1]
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == height.length</code></li>
	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= height[i] &lt;= 10<sup>4</sup></code></li>
</ul>


---

# 🛍️ Container-With-Most-Water | Explained

## Approach 1 (Two Pointer Technique)
### Intuition
The core idea behind this approach is to use a two-pointer technique, where one pointer starts from the beginning of the array and the other pointer starts from the end. This approach works because the area of the container is determined by the minimum height of the two lines and the distance between them. By moving the pointers towards each other, we can efficiently explore all possible containers and keep track of the maximum area found so far. Think of it like having two people, one at each end of a pool, trying to find the deepest point by moving towards each other.

### Approach
The algorithm works as follows:
1. Initialize two pointers, one at the beginning of the array (`left`) and one at the end (`right`).
2. Calculate the area of the container formed by the two lines at the current positions of the pointers.
3. Update the maximum area if the current area is larger.
4. Move the pointer of the shorter line towards the other pointer. This is because moving the pointer of the taller line wouldn't increase the area, as the area is limited by the height of the shorter line.
5. Repeat steps 2-4 until the pointers meet.

### Detailed Code Analysis
Let's break down the code line by line:
- `int left = 0;` and `int right = height.length - 1;`: Initialize the two pointers, `left` and `right`, to the beginning and end of the array, respectively.
- `int maxarea = 0;`: Initialize the `maxarea` variable to keep track of the maximum area found so far.
- `while (left < right)`: Continue the loop until the pointers meet.
- `int minheight = Math.min(height[left], height[right]);`: Calculate the minimum height of the two lines at the current positions of the pointers.
- `int width = right - left;`: Calculate the width of the container.
- `int area = width * minheight;`: Calculate the area of the container.
- `maxarea = Math.max(area, maxarea);`: Update the `maxarea` if the current area is larger.
- `if (height[left] < height[right])`: Compare the heights of the two lines at the current positions of the pointers.
- `left++;` and `right--;`: Move the pointer of the shorter line towards the other pointer.
- `return maxarea;`: Return the maximum area found.

### Code
```java
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxarea = 0;
        while (left < right) {
            int minheight = Math.min(height[left], height[right]);
            int width = right - left;
            int area = width * minheight;
            maxarea = Math.max(area, maxarea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxarea;
    }
}
```

### Complexity
- Time: The time complexity of this approach is **O(n)**, where n is the number of elements in the array. This is because we are scanning the array once, and each operation inside the loop takes constant time.
- Space: The space complexity of this approach is **O(1)**, as we are only using a constant amount of space to store the pointers and the maximum area.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some possible follow-up questions for this problem could be:
- What if the input array is not sorted? Would the solution still work?
  - The solution would still work, as it doesn't rely on the array being sorted. The two-pointer technique is used to find the maximum area, and it works regardless of the order of the elements.
- How would you optimize the solution for very large inputs?
  - The solution is already optimized for large inputs, as it has a time complexity of O(n) and uses a constant amount of space. However, if the input array is extremely large, you might need to consider using a more efficient data structure, such as a heap or a balanced binary search tree, to store the elements. But for the given problem, the two-pointer technique is sufficient.