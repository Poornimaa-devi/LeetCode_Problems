<h2><a href="https://leetcode.com/problems/search-in-rotated-sorted-array">33. Search in Rotated Sorted Array</a></h2>

<p>There is an integer array <code>nums</code> sorted in ascending order (with <strong>distinct</strong> values).</p>

<p>Prior to being passed to your function, <code>nums</code> is <strong>possibly left rotated</strong> at an unknown index <code>k</code> (<code>1 &lt;= k &lt; nums.length</code>) such that the resulting array is <code>[nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]</code> (<strong>0-indexed</strong>). For example, <code>[0,1,2,4,5,6,7]</code> might be left rotated by&nbsp;<code>3</code>&nbsp;indices and become <code>[4,5,6,7,0,1,2]</code>.</p>

<p>Given the array <code>nums</code> <strong>after</strong> the possible rotation and an integer <code>target</code>, return <em>the index of </em><code>target</code><em> if it is in </em><code>nums</code><em>, or </em><code>-1</code><em> if it is not in </em><code>nums</code>.</p>

<p>You must write an algorithm with <code>O(log n)</code> runtime complexity.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [4,5,6,7,0,1,2], target = 0
<strong>Output:</strong> 4
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [4,5,6,7,0,1,2], target = 3
<strong>Output:</strong> -1
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> nums = [1], target = 0
<strong>Output:</strong> -1
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 5000</code></li>
	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
	<li>All values of <code>nums</code> are <strong>unique</strong>.</li>
	<li><code>nums</code> is an ascending array that is possibly rotated.</li>
	<li><code>-10<sup>4</sup> &lt;= target &lt;= 10<sup>4</sup></code></li>
</ul>


---

# 🛍️ Search-in-Rotated-Sorted-Array | Explained

## Approach 1: Brute Force Search
### Intuition
🤔 The core idea behind this approach is to simply iterate through the array and check each element to see if it matches the target. This works because, although the array is rotated, we can still find the target by checking every element. Think of it like searching for a specific book in a library where the books are not arranged in order - we have to check every book until we find the one we're looking for.

### Approach
📚 The algorithm works as follows:
1. Start at the beginning of the array.
2. Check if the current element is the target.
3. If it is, return the index of the current element.
4. If not, move to the next element in the array.
5. Repeat steps 2-4 until the entire array has been checked.
6. If the target is not found after checking every element, return -1 to indicate that the target is not in the array.

### Detailed Code Analysis
🔍 Let's dive into the code:
- `for(int i=0;i<nums.length;i++)`: This loop iterates over each element in the array. The variable `i` represents the current index, starting from 0 (the first element) and going up to `nums.length - 1` (the last element).
- `if(nums[i]==target) return i;`: Inside the loop, we check if the current element `nums[i]` is equal to the target. If it is, we immediately return the index `i`, as we've found the target.
- `return -1;`: If the loop completes without finding the target, this line returns -1 to indicate that the target is not in the array.

### Code
```java
for(int i=0;i<nums.length;i++){
    if(nums[i]==target) return i;
}
return -1;
```

### Complexity
- Time: 🕒 The time complexity of this approach is O(n), where n is the number of elements in the array. This is because in the worst-case scenario, we have to check every element in the array.
- Space: 🗂️ The space complexity is O(1), which means the space required does not change with the size of the input array, making it very efficient in terms of memory usage.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this pattern might include:
1. **How would you optimize the search for a very large array?** 
   - Answer: For a very large array, a more efficient algorithm would be to use a modified binary search since the array was originally sorted before rotation. This approach would have a time complexity of O(log n), significantly improving performance for large arrays.
2. **What if the array is not rotated, is the solution still applicable?**
   - Answer: Yes, the brute force search solution still applies even if the array is not rotated. However, in such a case, using a binary search algorithm would be more efficient as it takes advantage of the sorted property of the array.