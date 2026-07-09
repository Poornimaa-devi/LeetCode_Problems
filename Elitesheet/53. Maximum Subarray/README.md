<h2><a href="https://leetcode.com/problems/maximum-subarray">53. Maximum Subarray</a></h2>

<p>Given an integer array <code>nums</code>, find the <span data-keyword="subarray-nonempty" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_1l_" data-state="closed" class="">subarray</button></span> with the largest sum, and return <em>its sum</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [-2,1,-3,4,-1,2,1,-5,4]
<strong>Output:</strong> 6
<strong>Explanation:</strong> The subarray [4,-1,2,1] has the largest sum 6.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1]
<strong>Output:</strong> 1
<strong>Explanation:</strong> The subarray [1] has the largest sum 1.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [5,4,-1,7,8]
<strong>Output:</strong> 23
<strong>Explanation:</strong> The subarray [5,4,-1,7,8] has the largest sum 23.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> If you have figured out the <code>O(n)</code> solution, try coding another solution using the <strong>divide and conquer</strong> approach, which is more subtle.</p>


---

# 🛍️ Maximum-Subarray | Explained

## Approach 1 (Kadane's Algorithm)
### Intuition
The core idea behind this approach is to treat the maximum subarray problem as a running sum problem. Imagine you're on a hike, and you're keeping track of your elevation gain/loss as you walk. If your current elevation is below sea level, it's better to start fresh from the current point rather than carrying the previous losses with you. This approach works because it considers all possible subarrays and keeps track of the maximum sum seen so far.

### Approach
The algorithm works by iterating over the input array and maintaining a running sum of the current subarray. At each step, it decides whether to continue adding elements to the current subarray or start a new one. This decision is made by comparing the current sum with the current element. If the current sum is negative, it's better to start a new subarray.

### Detailed Code Analysis
Let's dive into the code block:

- `int curr = 0;` initializes the running sum of the current subarray to 0.
- `int max = nums[0];` initializes the maximum sum seen so far to the first element of the array. This is because the maximum subarray sum must be at least the maximum single element in the array.
- `for (int i = 0; i < nums.length; i++)` iterates over the input array.
- `curr = Math.max(curr, 0);` is where the magic happens. This line decides whether to continue adding elements to the current subarray or start a new one. If `curr` is negative, it sets `curr` to 0, effectively starting a new subarray from the current point.
- `curr += nums[i];` adds the current element to the running sum of the current subarray.
- `max = Math.max(max, curr);` updates the maximum sum seen so far. However, there's an issue with the placement of this line in the provided code. It should be inside the loop to update the maximum sum after considering each element.

### Code
```java
class Solution {
    public int maxSubArray(int[] nums) {
        int curr = 0;
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            curr = Math.max(curr, 0);
            curr += nums[i];
            max = Math.max(max, curr); // corrected placement
        }
        return max;
    }
}
```

### Complexity
- Time: The time complexity of this approach is O(n), where n is the length of the input array. This is because we make a single pass through the array.
- Space: The space complexity of this approach is O(1), which means the space required does not grow with the size of the input array, making it very efficient in terms of memory usage.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this problem include:
1. How would you modify the solution to find the actual subarray that gives the maximum sum, not just the sum itself?
   - To do this, you would need to keep track of the start and end indices of the current subarray and update them whenever you start a new subarray or find a new maximum sum.
2. What if the input array is empty?
   - You would need to add a check at the beginning of the function to handle this edge case, for example, by throwing an exception or returning a specific value to indicate an error.