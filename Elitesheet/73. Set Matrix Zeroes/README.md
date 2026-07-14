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

## Approach 1 (Two-Pass)
### Intuition
Imagine you're a librarian, and you have a huge bookshelf (matrix) with books (cells) on it. You need to find all the books that are defective (zero) and then mark all the shelves (rows) and sections (columns) where those defective books are located. After that, you go back and replace all the books on the marked shelves and sections with defective ones (zero). This approach works because it allows us to identify the rows and columns that need to be zeroed out without modifying the original matrix until we've had a chance to examine every cell.

### Approach
The two-pass approach involves first identifying the rows and columns that contain zeros, and then using that information to set the corresponding cells in the matrix to zero. Here's a high-level breakdown of the steps:
1. Iterate over the matrix to identify the rows and columns that contain zeros.
2. Record the indices of the rows and columns that contain zeros in separate arrays.
3. Iterate over the matrix again, and for each cell, check if its row or column index is in the arrays of indices to be zeroed out.
4. If a cell's row or column index is in the arrays, set the cell to zero.

### Detailed Code Analysis
Let's take a closer look at the code:
```java
int rowCount = matrix.length;
int colCount = matrix[0].length;
```
These lines initialize variables to store the number of rows and columns in the matrix.

```java
boolean[] rows = new boolean[rowCount];
boolean[] cols = new boolean[colCount];
boolean isEmpty = true;
```
These lines create boolean arrays to keep track of which rows and columns need to be zeroed out. The `isEmpty` variable is used to track whether any zeros were found in the matrix.

```java
for (int i = 0; i < rowCount; i++)
    for (int j = 0; j < colCount; j++)
        if (matrix[i][j] == 0) {
            rows[i] = true;
            cols[j] = true;
            isEmpty = false;
        }
```
This nested loop iterates over the matrix, checking each cell for zeros. When a zero is found, the corresponding row and column indices are marked for zeroing out in the `rows` and `cols` arrays, and the `isEmpty` variable is set to `false`.

```java
if (!isEmpty)
    for (int i = 0; i < rowCount; i++)
        for (int j = 0; j < colCount; j++)
            if (rows[i] || cols[j])
                matrix[i][j] = 0;
```
If the `isEmpty` variable is `false`, this nested loop iterates over the matrix again, setting cells to zero if their row or column index is marked for zeroing out.

### Code
```java
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
```

### Complexity
- Time: O(m * n), where m is the number of rows and n is the number of columns in the matrix. This is because we're iterating over the matrix twice: once to identify the rows and columns to be zeroed out, and again to actually zero out the corresponding cells.
- Space: O(m + n), where m is the number of rows and n is the number of columns in the matrix. This is because we're using boolean arrays to keep track of the rows and columns to be zeroed out.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some possible follow-up questions for this problem might include:
- What if the input matrix is extremely large? How would you optimize the solution to handle that case?
  Answer: One possible optimization would be to use a more space-efficient data structure to keep track of the rows and columns to be zeroed out, such as a HashSet or a bit vector.
- What if the input matrix is sparse (i.e., most of the cells are zeros)? How would you take advantage of that property to optimize the solution?
  Answer: One possible optimization would be to use a sparse matrix representation, such as a dictionary of (row, column) pairs, to store the non-zero cells. This could reduce the space complexity of the solution.