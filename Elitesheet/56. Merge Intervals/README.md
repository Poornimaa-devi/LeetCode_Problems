<h2><a href="https://leetcode.com/problems/merge-intervals">56. Merge Intervals</a></h2>

<p>Given an array&nbsp;of <code>intervals</code>&nbsp;where <code>intervals[i] = [start<sub>i</sub>, end<sub>i</sub>]</code>, merge all overlapping intervals, and return <em>an array of the non-overlapping intervals that cover all the intervals in the input</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> intervals = [[1,3],[2,6],[8,10],[15,18]]
<strong>Output:</strong> [[1,6],[8,10],[15,18]]
<strong>Explanation:</strong> Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> intervals = [[1,4],[4,5]]
<strong>Output:</strong> [[1,5]]
<strong>Explanation:</strong> Intervals [1,4] and [4,5] are considered overlapping.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> intervals = [[4,7],[1,4]]
<strong>Output:</strong> [[1,7]]
<strong>Explanation:</strong> Intervals [1,4] and [4,7] are considered overlapping.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= intervals.length &lt;= 10<sup>4</sup></code></li>
	<li><code>intervals[i].length == 2</code></li>
	<li><code>0 &lt;= start<sub>i</sub> &lt;= end<sub>i</sub> &lt;= 10<sup>4</sup></code></li>
</ul>


---

# 🛍️ Merge-Intervals | Explained

## Approach 1 (Balanced Binary Search Tree)
### Intuition
The intuition behind this approach is to use a balanced binary search tree (BST) to store the intervals. Each node in the BST represents an interval, and the tree is balanced based on the midpoint of the interval. This approach works because it allows us to efficiently merge overlapping intervals by traversing the tree and updating the node values as needed. Think of it like a librarian organizing books on a shelf. The librarian uses a balanced system to store the books, making it easy to find and merge books with similar titles (intervals).

### Approach
The approach involves the following steps:
1. Create a BST with a custom node class (`TreeNode`) that stores the start, end, and midpoint of an interval.
2. Insert all intervals into the BST using a recursive `add` method.
3. Traverse the BST using a recursive `query` method to merge overlapping intervals and return the merged intervals.

### Detailed Code Analysis
Let's dive into the code block:
* The `TreeNode` class is defined with `start`, `end`, and `middle` attributes, which represent the start, end, and midpoint of an interval, respectively. The `left` and `right` attributes are used to balance the BST.
* The `Solution` class has an `__init__` method that initializes the `root` node of the BST.
* The `merge` method is the main entry point for the solution. It checks if the input `intervals` list is empty and returns an empty list if so. Otherwise, it inserts all intervals into the BST using the `add` method and then calls the `query` method to merge the intervals.
* The `add` method is a recursive method that inserts an interval into the BST. It uses the midpoint of the node's interval to determine whether to insert the new interval into the left or right subtree.
* The `query` method is a recursive method that traverses the BST and merges overlapping intervals. It uses a divide-and-conquer approach to merge the intervals in the left and right subtrees and then updates the current node's interval accordingly.

### Code
```python
class TreeNode:
    def __init__(self, start, end, middle):
        self.start = start
        self.end = end
        self.middle = middle
        self.left = self.right = None

class Solution:
    def __init__(self):
        self.root = None
    
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if not intervals:
            return []
        
        for start, end in intervals:
            if not self.root:
                self.root = TreeNode(start, end, (start + end) // 2)
            else:
                self.add(self.root, start, end)
        
        return self.query(self.root)
    
    
    def add(self, node, start, end):     
        if end < node.middle:
            if node.left:
                self.add(node.left, start, end)
            else:
                node.left = TreeNode(start, end, (start + end) // 2)
        
        elif start > node.middle:
            if node.right:
                self.add(node.right, start, end)
            else:
                node.right = TreeNode(start, end, (start + end) // 2)
        
        else:
            node.start = min(node.start, start)
            node.end = max(node.end, end)
    
    def query(self, node):
        if not node:
            return []
        
        # merge-sort divide and conquer
        left_intervals = self.query(node.left)
        right_intervals = self.query(node.right)
        res = []
        
        inserted = False
        
        for lres in left_intervals:
            if lres[1] < node.start:
                res.append(lres)
            else:
                res.append([min(lres[0], node.start), node.end])
                inserted = True
                break
        
        if not inserted:
            res.append([node.start, node.end])
        
        for rres in right_intervals:
            if rres[0] <= node.end:
                res[-1][1] = max(node.end, rres[1])
            else:
                res.append(rres)
        
        return res
```

### Complexity
- Time: The time complexity of this solution is O(n log n) due to the recursive nature of the `add` and `query` methods. The `add` method has a time complexity of O(log n) because it uses a balanced BST, and the `query` method has a time complexity of O(n) because it traverses the entire tree. However, the `query` method is called recursively, resulting in a total time complexity of O(n log n).
- Space: The space complexity of this solution is O(n) because it uses a BST to store all intervals. The `query` method also uses a recursive approach, which requires O(n) space on the call stack.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this problem include:
* How would you optimize the solution for large input intervals? 
Answer: To optimize the solution for large input intervals, you could use a more efficient data structure, such as a heap or a balanced BST with a more efficient node update strategy.
* How would you handle the case where the input intervals are not sorted? 
Answer: If the input intervals are not sorted, you would need to sort them before inserting them into the BST. This would add an additional O(n log n) time complexity to the solution.