<h2><a href="https://leetcode.com/problems/single-element-in-a-sorted-array">540. Single Element in a Sorted Array</a></h2>

<p>You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.</p>

<p>Return <em>the single element that appears only once</em>.</p>

<p>Your solution must run in <code>O(log n)</code> time and <code>O(1)</code> space.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [1,1,2,3,3,4,4,8,8]
<strong>Output:</strong> 2
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [3,3,7,7,10,11,11]
<strong>Output:</strong> 10
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= nums[i] &lt;= 10<sup>5</sup></code></li>
</ul>


---

# 🛍️ Single-Element-in-a-Sorted-Array | Explained

## Approach 1 (Binary Search)
### Intuition
The intuition behind this approach is to utilize the property of the given array, where every element appears twice except for one. By leveraging the fact that the array is sorted, we can apply a modified binary search algorithm to find the single element. This approach works because the array's sorted nature allows us to make educated guesses about the possible location of the single element.

### Approach
The approach involves a step-by-step process:
1. Initialize two pointers, `l` (left) and `r` (right), to the start and end of the array respectively.
2. Loop until `l` is no longer less than `r`.
3. In each iteration, calculate the `mid` index.
4. Adjust the `mid` index if it's odd, to ensure we're always comparing pairs of elements.
5. Compare the elements at the `mid` and `mid+1` indices. If they're equal, the single element must be in the right half of the array, so update `l` to `mid+2`. Otherwise, the single element must be in the left half, so update `r` to `mid`.

### Detailed Code Analysis
Let's dive into the code:
- Line 1-2: The class `Solution` and the method `singleNonDuplicate` are defined. The method takes an array of integers `nums` as input and returns the single non-duplicate element.
- Line 3-4: Initialize the `l` (left) and `r` (right) pointers to the start and end of the array, respectively.
- Line 5: Loop until `l` is no longer less than `r`.
- Line 6: Calculate the `mid` index using the formula `(r+l)/2`. This is the standard way to calculate the middle index in binary search.
- Line 7-9: If the `mid` index is odd, decrement it by 1. This is done to ensure we're always comparing pairs of elements. When `mid` is odd, `mid+1` would be out of bounds if `mid` was the last index, but by decrementing `mid`, we're essentially looking at the element before `mid` and its pair, which is at `mid+1`.
- Line 10-14: Compare the elements at the `mid` and `mid+1` indices. If they're equal, update `l` to `mid+2`, indicating that the single element must be in the right half of the array. Otherwise, update `r` to `mid`, indicating that the single element must be in the left half.
- Line 16: Once the loop ends, `l` points to the single non-duplicate element. Return `nums[l]`.

### Code
```java
class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (r + l) / 2;
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] == nums[mid + 1]) {
                l = mid + 2;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }
}
```

### Complexity
- Time: The time complexity of this approach is O(log n), where n is the number of elements in the array. This is because we're performing a binary search, which reduces the search space by half in each iteration.
- Space: The space complexity is O(1), which means the space required does not change with the size of the input array. This is because we're only using a constant amount of space to store the `l`, `r`, and `mid` indices, regardless of the input size.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this problem include:
1. How would you modify the solution to handle an unsorted array?
   - To handle an unsorted array, you could first sort the array using a sorting algorithm like quicksort or mergesort, which would take O(n log n) time. Then, you could apply the same binary search approach to find the single non-duplicate element.
2. What if the array is very large and doesn't fit into memory?
   - If the array is too large to fit into memory, you could consider using a disk-based approach, where you read the array in chunks and process each chunk separately. Alternatively, you could use a distributed computing approach, where you split the array across multiple machines and process each part in parallel. However, these approaches would be more complex and may require significant additional infrastructure.