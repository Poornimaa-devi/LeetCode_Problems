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

## Approach 1: Binary Search in a 2D Matrix
### Intuition
Imagine you have a large library with books arranged on shelves in a specific order. Each shelf represents a row in the matrix, and each book represents an element in the row. If you want to find a specific book, you wouldn't start by searching the entire library shelf by shelf. Instead, you would use a more efficient approach, like looking at the middle shelf and deciding whether the book is likely to be on a higher or lower shelf. This approach is similar to what we're doing here, but instead of shelves and books, we're working with rows and columns in a 2D matrix. The key insight is to treat the 2D matrix as a single, sorted array and apply a binary search algorithm to find the target element.

### Approach
The approach involves:
1. Calculating the number of rows and columns in the matrix.
2. Initializing two pointers, `low` and `high`, to represent the range of indices in the "flattened" array.
3. Applying a binary search algorithm to find the target element.
4. If the target element is found, return `true`. Otherwise, adjust the `low` and `high` pointers accordingly and repeat the search until the target is found or the search space is exhausted.

### Detailed Code Analysis
Let's dive into the code:
```java
int rows = matrix.length;
int cols = matrix[0].length;
```
These lines calculate the number of rows and columns in the matrix, which will be used to map the 2D indices to a 1D index.

```java
int low = 0;
int high = rows*cols-1;
```
These lines initialize the `low` and `high` pointers to represent the range of indices in the "flattened" array.

```java
while(low<=high){
    int mid = (low+high)/2;
    int r = mid/cols;
    int c = mid%cols;
    int curr = matrix[r][c];
    ...
}
```
This block applies the binary search algorithm:
- `mid` is the midpoint of the current search range.
- `r` and `c` are the row and column indices corresponding to the `mid` index in the "flattened" array.
- `curr` is the value at the `mid` index.

The comparison `if(curr==target) return true;` checks if the current element is the target element. If it is, the function returns `true`.

```java
if(curr<target){
    low=mid+1;
}else{
    high=mid-1;
}
```
This block adjusts the `low` and `high` pointers based on the comparison between the current element and the target element.

### Code
```java
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int low = 0;
        int high = rows*cols-1;
        while(low<=high){
            int mid = (low+high)/2;
            int r = mid/cols;
            int c = mid%cols;
            int curr = matrix[r][c];
            if(curr==target) return true;
            if(curr<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return false;
    }
}
```

### Complexity
- Time: The time complexity is O(log(m*n)), where m is the number of rows and n is the number of columns in the matrix. This is because we're applying a binary search algorithm to the "flattened" array, which has a length of m*n.
- Space: The space complexity is O(1), which means the space required does not change with the size of the input matrix. This is because we're only using a constant amount of space to store the `low`, `high`, `mid`, `r`, `c`, and `curr` variables.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some potential follow-up questions and brief answers:
- Q: What if the matrix is not sorted?
A: The algorithm assumes that the matrix is sorted in a specific way (each row is sorted from left to right, and the last element of each row is less than or equal to the first element of the next row). If the matrix is not sorted, a different approach would be needed.
- Q: Can you apply this approach to a 3D matrix?
A: Yes, the approach can be extended to a 3D matrix by treating it as a "flattened" 1D array and applying the binary search algorithm. However, the mapping from 3D indices to a 1D index would be more complex, involving the product of the number of rows, columns, and depth.