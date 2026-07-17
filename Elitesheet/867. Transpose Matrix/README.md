<h2><a href="https://leetcode.com/problems/transpose-matrix">867. Transpose Matrix</a></h2>

<p>Given a 2D integer array <code>matrix</code>, return <em>the <strong>transpose</strong> of</em> <code>matrix</code>.</p>

<p>The <strong>transpose</strong> of a matrix is the matrix flipped over its main diagonal, switching the matrix's row and column indices.</p>

<p><img alt="" src="https://assets.leetcode.com/uploads/2021/02/10/hint_transpose.png" style="width: 600px; height: 197px;"></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> matrix = [[1,2,3],[4,5,6],[7,8,9]]
<strong>Output:</strong> [[1,4,7],[2,5,8],[3,6,9]]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> matrix = [[1,2,3],[4,5,6]]
<strong>Output:</strong> [[1,4],[2,5],[3,6]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == matrix.length</code></li>
	<li><code>n == matrix[i].length</code></li>
	<li><code>1 &lt;= m, n &lt;= 1000</code></li>
	<li><code>1 &lt;= m * n &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= matrix[i][j] &lt;= 10<sup>9</sup></code></li>
</ul>


---

# 🛍️ Transpose-Matrix | Explained

## Approach 1: Brute Force Matrix Transposition
### Intuition
The core idea behind this approach is to create a new matrix with the dimensions swapped compared to the original matrix. This is akin to rotating a piece of paper 90 degrees and then flipping it over, effectively transposing the contents. This approach works because it systematically iterates over each element in the original matrix and assigns it to the corresponding transposed position in the new matrix.

### Algorithm Visualized
```mermaid
graph LR
    A[Original Matrix] -->|Iterate over rows and columns|> B[New Matrix with swapped dimensions]
    B -->|Assign elements to transposed positions|> C[Transposed Matrix]
```

### Approach
The algorithm starts by determining the dimensions of the original matrix. It then creates a new matrix with the dimensions swapped. The algorithm iterates over each element in the original matrix, and for each element, it assigns the value to the corresponding transposed position in the new matrix.

### Detailed Code Analysis
The provided code snippet is as follows:
```java
class Solution {
    public int[][] transpose(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[][] arr = new int[c][r];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                arr[j][i]= matrix[i][j];
            }
        }
        return arr;
    }
}
```
Let's break down the code line by line:
- `int r = matrix.length;` determines the number of rows in the original matrix.
- `int c = matrix[0].length;` determines the number of columns in the original matrix, assuming all rows have the same number of columns.
- `int[][] arr = new int[c][r];` creates a new matrix with the dimensions swapped compared to the original matrix.
- The nested `for` loops iterate over each element in the original matrix. The outer loop iterates over the rows (`i`), and the inner loop iterates over the columns (`j`).
- `arr[j][i]= matrix[i][j];` assigns the value of the current element in the original matrix to the corresponding transposed position in the new matrix.

### Complexity
- **Time:** The time complexity of this approach is O(r * c), where r is the number of rows and c is the number of columns in the original matrix. This is because the algorithm iterates over each element in the matrix once.
- **Space:** The space complexity of this approach is also O(r * c), as the algorithm creates a new matrix with the same number of elements as the original matrix.