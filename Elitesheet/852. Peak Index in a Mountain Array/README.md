<h2><a href="https://leetcode.com/problems/peak-index-in-a-mountain-array">852. Peak Index in a Mountain Array</a></h2>

<p>You are given an integer <strong>mountain</strong> array <code>arr</code> of length <code>n</code> where the values increase to a <strong>peak element</strong> and then decrease.</p>

<p>Return the index of the peak element.</p>

<p>Your task is to solve it in <code>O(log(n))</code> time complexity.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">arr = [0,1,0]</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">arr = [0,2,1,0]</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">arr = [0,10,5,2]</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= arr.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= arr[i] &lt;= 10<sup>6</sup></code></li>
	<li><code>arr</code> is <strong>guaranteed</strong> to be a mountain array.</li>
</ul>


---

# 🛍️ Peak-Index-in-a-Mountain-Array | Explained

## Approach 1 (Optimized Binary Search)
### Intuition
Imagine you're climbing a mountain, and you want to find the peak. You start at the base and take a step to the middle. If the middle point is higher than the next point, you know the peak must be to the left of the middle. If the middle point is lower than the next point, the peak must be to the right of the middle. This intuition is the core of the optimized binary search approach, which allows us to find the peak index in a mountain array efficiently.

### Approach
The approach involves using a binary search algorithm to find the peak index in the mountain array. The algorithm starts by initializing two pointers, `left` and `right`, to the start and end of the array, respectively. It then enters a loop where it calculates the midpoint `mid` and compares the value at `mid` with the value at `mid + 1`. Based on this comparison, it adjusts the `left` or `right` pointer to narrow down the search range.

### Detailed Code Analysis
Let's dive into the code block:
```java
1class Solution {
2    public int peakIndexInMountainArray(int[] arr) {
3        int left = 0;
4        int right = arr.length-1;
5        while(left<right){
6            int mid = left+(right-left)/2;
7            if(arr[mid+1]<arr[mid]) right=mid;
8            else{
9                left=mid+1;
10            }
11        }
12        return left;
13    }
14}
```
Here's what the code is doing:

- Line 1-2: The class `Solution` and method `peakIndexInMountainArray` are defined.
- Line 3-4: The `left` pointer is initialized to 0 (the start of the array), and the `right` pointer is initialized to the last index of the array (`arr.length-1`).
- Line 5: The code enters a while loop that continues as long as `left` is less than `right`.
- Line 6: The midpoint `mid` is calculated using the formula `left+(right-left)/2`, which is a common way to calculate the midpoint in binary search to avoid integer overflow.
- Line 7: The code checks if the value at `mid + 1` is less than the value at `mid`. If this condition is true, it means the peak must be to the left of `mid`, so the `right` pointer is updated to `mid`.
- Line 8-10: If the condition in line 7 is false, it means the peak must be to the right of `mid`, so the `left` pointer is updated to `mid + 1`.
- Line 11: The loop continues until `left` is no longer less than `right`.
- Line 12: Once the loop exits, the `left` pointer points to the peak index, which is returned as the result.

### Code
```java
int left = 0;
int right = arr.length-1;
while(left<right){
    int mid = left+(right-left)/2;
    if(arr[mid+1]<arr[mid]) right=mid;
    else{
        left=mid+1;
    }
}
return left;
```
### Complexity
- Time: **O(log n)**, where n is the length of the input array. This is because the binary search algorithm reduces the search range by half at each iteration.
- Space: **O(1)**, as the algorithm only uses a constant amount of space to store the `left`, `right`, and `mid` pointers, regardless of the input size.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this problem are:
- What if the input array is not a mountain array (i.e., it doesn't have a peak)? How would you modify the algorithm to handle such cases?
- Can you implement a solution using a different approach, such as a linear scan or a recursive function?