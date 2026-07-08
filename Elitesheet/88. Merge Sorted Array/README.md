<h2><a href="https://leetcode.com/problems/merge-sorted-array">88. Merge Sorted Array</a></h2>

<p>You are given two integer arrays <code>nums1</code> and <code>nums2</code>, sorted in <strong>non-decreasing order</strong>, and two integers <code>m</code> and <code>n</code>, representing the number of elements in <code>nums1</code> and <code>nums2</code> respectively.</p>

<p><strong>Merge</strong> <code>nums1</code> and <code>nums2</code> into a single array sorted in <strong>non-decreasing order</strong>.</p>

<p>The final sorted array should not be returned by the function, but instead be <em>stored inside the array </em><code>nums1</code>. To accommodate this, <code>nums1</code> has a length of <code>m + n</code>, where the first <code>m</code> elements denote the elements that should be merged, and the last <code>n</code> elements are set to <code>0</code> and should be ignored. <code>nums2</code> has a length of <code>n</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
<strong>Output:</strong> [1,2,2,3,5,6]
<strong>Explanation:</strong> The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [<u>1</u>,<u>2</u>,2,<u>3</u>,5,6] with the underlined elements coming from nums1.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums1 = [1], m = 1, nums2 = [], n = 0
<strong>Output:</strong> [1]
<strong>Explanation:</strong> The arrays we are merging are [1] and [].
The result of the merge is [1].
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums1 = [0], m = 0, nums2 = [1], n = 1
<strong>Output:</strong> [1]
<strong>Explanation:</strong> The arrays we are merging are [] and [1].
The result of the merge is [1].
Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>nums1.length == m + n</code></li>
	<li><code>nums2.length == n</code></li>
	<li><code>0 &lt;= m, n &lt;= 200</code></li>
	<li><code>1 &lt;= m + n &lt;= 200</code></li>
	<li><code>-10<sup>9</sup> &lt;= nums1[i], nums2[j] &lt;= 10<sup>9</sup></code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up: </strong>Can you come up with an algorithm that runs in <code>O(m + n)</code> time?</p>


---

# 🛍️ Merge-Sorted-Array | Explained
This problem involves merging two sorted arrays into one sorted array. The given code solution presents an efficient approach to solve this problem.

## Approach 1 (Two Pointer Technique)
### Intuition
Imagine you have two stacks of cards, each sorted in descending order. You want to merge these two stacks into one stack, also in descending order. You can do this by comparing the top card of each stack and placing the larger card on top of the new stack. This process continues until one of the stacks is empty, at which point you can simply add the remaining cards from the other stack to the new stack.
### Approach
The algorithm uses three pointers: `i`, `j`, and `k`. `i` points to the last element of the first array (`nums1`), `j` points to the last element of the second array (`nums2`), and `k` points to the last position where we can place an element in `nums1`. The algorithm compares the elements at `i` and `j` and places the larger one at position `k`. It then decrements the corresponding pointer and `k`. This process continues until one of the arrays is exhausted. If `nums2` is not empty after the loop, the remaining elements are copied to `nums1`.
### Code
```java
int i = m-1;
int j = n-1;
int k = m+n-1;
while(i>=0 && j>=0){
    if(nums1[i]>nums2[j]){
        nums1[k]=nums1[i];
        i--;
    }else{
        nums1[k]=nums2[j];
        j--;
    }
    k--;
}

while(j>=0){
    nums1[k]=nums2[j];
    j--;
    k--;
}
```
### Complexity
- Time: O(m + n), where m and n are the lengths of `nums1` and `nums2` respectively. This is because we are scanning both arrays once.
- Space: O(1), as we are only using a constant amount of space to store the pointers and do not allocate any additional arrays.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this problem are:
- What if the input arrays are not sorted? How would you modify the algorithm to handle this case?
  - In this case, you would need to sort the input arrays before merging them. You could use a sorting algorithm like quicksort or mergesort to sort the arrays, and then use the same two-pointer technique to merge them.
- What if the input arrays are very large and do not fit in memory? How would you modify the algorithm to handle this case?
  - In this case, you would need to use a more efficient data structure, such as a heap or a balanced binary search tree, to store the elements of the input arrays. You could also use a streaming approach, where you read the input arrays one element at a time and merge them on the fly.