<h2><a href="https://leetcode.com/problems/set-matrix-zeroes">73. Set Matrix Zeroes</a></h2>

<p>Given an <code>m x n</code> integer matrix <code>matrix</code>, if an element is <code>0</code>, set its entire row and column to <code>0</code>'s.</p>

<p>You must do it <a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank">in place</a>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/08/17/mat1.jpg" style="width: 450px; height: 169px;">
<pre><strong>Input:</strong> matrix = [[1,1,1],[1,0,1],[1,1,1]]
<strong>Output:</strong> [[1,0,1],[0,0,0],[1,0,1]]
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://assets.leetcode.com/uploads/2020/08/17/mat2.jpg" style="width: 450px; height: 137px;">
<pre><strong>Input:</strong> matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
<strong>Output:</strong> [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == matrix.length</code></li>
	<li><code>n == matrix[0].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 200</code></li>
	<li><code>-2<sup>31</sup> &lt;= matrix[i][j] &lt;= 2<sup>31</sup> - 1</code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong></p>

<ul>
	<li>A straightforward solution using <code>O(mn)</code> space is probably a bad idea.</li>
	<li>A simple improvement uses <code>O(m + n)</code> space, but still not the best solution.</li>
	<li>Could you devise a constant space solution?</li>
</ul>


---

# 🛍️ Set-Matrix-Zeroes | Explained

## Approach 1 (Two-Pass with Extra Space)
### Intuition
Imagine you're the manager of a large library with rows of shelves. Each shelf represents a row in the matrix, and each book on the shelf represents an element in that row. When you find a book with a "zero" label (representing a zero in the matrix), you need to mark the entire shelf (row) and the section where the book is located (column) for later removal. This approach uses extra space (like sticky notes) to mark which rows and columns need to be zeroed out. The two-pass method ensures that we first identify which rows and columns to zero out, and then we go back through and actually set those elements to zero.

### Approach
The algorithmic steps are as follows:
1. Initialize the number of rows and columns in the matrix.
2. Create two boolean arrays to keep track of which rows and columns need to be zeroed out.
3. Perform a first pass through the matrix to identify which rows and columns contain a zero.
4. Perform a second pass through the matrix to set the elements in the identified rows and columns to zero.

### Detailed Code Analysis
Let's take a closer look at the provided code. 
- Lines 3-4: We initialize `rowCount` and `colCount` to store the number of rows and columns in the matrix, respectively.
- Lines 5-6: We create two boolean arrays, `rows` and `cols`, to keep track of which rows and columns need to be zeroed out.
- Line 7: The `isEmpty` variable is initialized but is not actually necessary for the algorithm, as we can determine if the matrix has been modified by checking the `rows` and `cols` arrays after the first pass.
- In the first pass (lines 9-15), we iterate through each element in the matrix. If we find an element with a value of 0, we set the corresponding index in the `rows` and `cols` arrays to `true`.
- The `isEmpty` variable (line 14) is set to `false` when a zero is found, but as mentioned earlier, it's not crucial for the algorithm.
- In the second pass (lines 18-21), we iterate through the matrix again. This time, if the current row or column has been marked for zeroing out (i.e., `rows[i]` or `cols[j]` is `true`), we set the current element to 0.

### Code
```java
class Solution {
    public void setZeroes(int[][] matrix) {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;
        boolean[] rows = new boolean[rowCount];
        boolean[] cols = new boolean[colCount];
        boolean isEmpty = true;      
        
        for (int i = 0; i < rowCount; i++)
            for (int j = 0; j < colCount; j++)
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                    isEmpty = false;
                }
            
        if (!isEmpty)
            for (int i = 0; i < rowCount; i++)
                for (int j = 0; j < colCount; j++)
                    if (rows[i] || cols[j])
                        matrix[i][j] = 0;
    }
}
```
### Complexity
- Time: The time complexity is O(m*n), where m is the number of rows and n is the number of columns in the matrix. This is because we are performing two separate passes through the matrix.
- Space: The space complexity is O(m + n), as we are using two additional arrays of size m and n to keep track of rows and columns to be zeroed out.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this problem include:
1. Can you optimize the space complexity? Yes, we can optimize the space complexity to O(1) by using the first row and first column of the matrix to store the information about which rows and columns to zero out, instead of using separate arrays. However, this approach is more complex and requires additional checks to handle edge cases.
2. How would you handle a sparse matrix? The provided solution will work correctly for sparse matrices, as it only iterates through the elements of the matrix and does not rely on the density of the matrix. However, a more optimized solution might take advantage of the sparsity to reduce the time complexity.