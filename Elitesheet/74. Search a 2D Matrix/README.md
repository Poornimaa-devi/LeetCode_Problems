<h2><a href="https://leetcode.com/problems/search-a-2d-matrix">74. Search a 2D Matrix</a></h2>

<p>You are given an <code>m x n</code> integer matrix <code>matrix</code> with the following two properties:</p>

<ul>
	<li>Each row is sorted in non-decreasing order.</li>
	<li>The first integer of each row is greater than the last integer of the previous row.</li>
</ul>

<p>Given an integer <code>target</code>, return <code>true</code> <em>if</em> <code>target</code> <em>is in</em> <code>matrix</code> <em>or</em> <code>false</code> <em>otherwise</em>.</p>

<p>You must write a solution in <code>O(log(m * n))</code> time complexity.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/05/mat.jpg" style="width: 322px; height: 242px;">
<pre><strong>Input:</strong> matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
<strong>Output:</strong> true
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/10/05/mat2.jpg" style="width: 322px; height: 242px;">
<pre><strong>Input:</strong> matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == matrix.length</code></li>
	<li><code>n == matrix[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 100</code></li>
	<li><code>-10<sup>4</sup> &lt;= matrix[i][j], target &lt;= 10<sup>4</sup></code></li>
</ul>


---

# 🛍️ Search-a-2D-Matrix | Explained

## Approach 1 (Optimized Binary Search)
### Intuition
The core idea behind this approach is to treat the 2D matrix as a sorted 1D array. This works because the matrix is sorted in ascending order from left to right and top to bottom. By doing this, we can apply a modified binary search algorithm to efficiently find the target element in the matrix. Think of it like searching a dictionary where each page represents a row in the matrix, and the words on each page are the elements in the row. If you know the alphabetical order of the words, you can easily navigate through the pages to find a specific word.

### Approach
The approach involves the following steps:
1. Calculate the total number of elements in the matrix (rows * cols).
2. Initialize two pointers, low and high, to the start and end of the "virtual" 1D array.
3. Perform a standard binary search, where the mid index is calculated and then converted to row and column indices to access the corresponding element in the matrix.
4. If the target element is found, return true. If not, adjust the low and high pointers based on whether the current element is less than or greater than the target.
5. Repeat steps 3-4 until the low pointer exceeds the high pointer, indicating that the target element is not in the matrix.

### Detailed Code Analysis
Let's dive into the code block:
- Lines 3-4: `int rows = matrix.length;` and `int cols = matrix[0].length;` calculate the number of rows and columns in the matrix, respectively.
- Lines 5-6: `int low = 0;` and `int high = rows * cols - 1;` initialize the low and high pointers to the start and end of the "virtual" 1D array.
- Line 7: `while (low <= high) {` starts the binary search loop, which continues until the low pointer exceeds the high pointer.
- Line 8: `int mid = (low + high) / 2;` calculates the mid index of the current range.
- Lines 9-10: `int r = mid / cols;` and `int c = mid % cols;` convert the mid index to row and column indices, respectively, using integer division and modulo operations.
- Line 11: `int curr = matrix[r][c];` accesses the element at the calculated row and column indices.
- Line 12: `if (curr == target) return true;` checks if the current element is the target and returns true if found.
- Lines 13-16: `if (curr < target) { low = mid + 1; } else { high = mid - 1; }` adjusts the low and high pointers based on the comparison between the current element and the target.

### Code
```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = 0;
        int high = rows * cols - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int r = mid / cols;
            int c = mid % cols;
            int curr = matrix[r][c];
            if (curr == target) return true;
            if (curr < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}
```

### Complexity
- Time: The time complexity is O(log(n*m)), where n is the number of rows and m is the number of columns in the matrix. This is because we are performing a binary search on a "virtual" array of size n*m.
- Space: The space complexity is O(1), as we only use a constant amount of space to store the low, high, mid, r, c, and curr variables, and do not allocate any additional space that scales with the input size.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some potential follow-up questions for this problem include:
1. How would you modify the solution to handle an unsorted matrix? 
   Answer: You could use a linear search approach, checking each element in the matrix to see if it matches the target. However, this would increase the time complexity to O(n*m).
2. What if the matrix is sorted in descending order instead of ascending order? 
   Answer: You would need to modify the comparison in the binary search loop to adjust the low and high pointers accordingly. Specifically, you would increment low when the current element is greater than the target and decrement high when the current element is less than the target.