<h2><a href="https://leetcode.com/problems/sort-colors">75. Sort Colors</a></h2>

<p>Given an array <code>nums</code> with <code>n</code> objects colored red, white, or blue, sort them <strong><a href="https://en.wikipedia.org/wiki/In-place_algorithm" target="_blank">in-place</a> </strong>so that objects of the same color are adjacent, with the colors in the order red, white, and blue.</p>

<p>We will use the integers <code>0</code>, <code>1</code>, and <code>2</code> to represent the color red, white, and blue, respectively.</p>

<p>You must solve this problem without using the library's sort function.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [2,0,2,1,1,0]
<strong>Output:</strong> [0,0,1,1,2,2]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [2,0,1]
<strong>Output:</strong> [0,1,2]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 &lt;= n &lt;= 300</code></li>
	<li><code>nums[i]</code> is either <code>0</code>, <code>1</code>, or <code>2</code>.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong>&nbsp;Could you come up with a one-pass algorithm using only&nbsp;constant extra space?</p>


---

# 🛍️ Sort-Colors | Explained

## Approach 1 (Counting Sort)
### Intuition
Imagine you're organizing a collection of colored balls (0s, 1s, and 2s) into separate containers. You first count how many balls of each color you have. Then, you use these counts to place the balls into their respective containers in a single pass. This approach works because it takes advantage of the limited number of distinct values (0, 1, and 2) to efficiently sort the array.

### Approach
The algorithm consists of two main steps:

1. **Counting**: Iterate through the array to count the occurrences of each color (0, 1, and 2).
2. **Placement**: Use the counts to place the colors in their correct positions in the array.

### Detailed Code Analysis
Let's break down the code:
- Lines 3-6: Initialize variables `n`, `c0`, `c1`, and `c2` to store the array length and counts of each color, respectively.
- Lines 7-11: Iterate through the array using a for loop, incrementing the corresponding color count (`c0`, `c1`, or `c2`) when a color is encountered.
- Lines 12-20: Use the counts to place the colors in their correct positions in the array. This is done by iterating through the array and assigning the colors based on their counts.

### Code
```java
class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int c0 = 0;
        int c1 = 0;
        int c2 = 0;
        for(int i=0;i<n;i++){
            if(nums[i] == 0) c0++;
            if(nums[i] == 1) c1++;
            if(nums[i] == 2) c2++;
        }
        for(int i=0;i<c0;i++){
            nums[i] = 0;
        }
        for(int i=c0;i<c0+c1;i++){
            nums[i] = 1;
        }
        for(int i=c0+c1;i<c0+c1+c2;i++){
            nums[i] = 2;
        }
        return;
    }
}
```

### Complexity
- Time: **O(n)**, where n is the length of the input array. This is because we make two passes through the array: one for counting and one for placement.
- Space: **O(1)**, as we only use a constant amount of extra space to store the counts and the array length.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some possible follow-up questions for this pattern:
1. **What if the input array contains more than three distinct colors?** In that case, we would need to modify the algorithm to accommodate the additional colors. This could involve using a more general counting sort approach or a different sorting algorithm altogether.
2. **Can we optimize the algorithm to use less extra space?** The current algorithm uses a constant amount of extra space, which is optimal. However, we could potentially reduce the number of iterations through the array by combining the counting and placement steps into a single pass.