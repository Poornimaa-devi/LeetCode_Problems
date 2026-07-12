<h2><a href="https://leetcode.com/problems/sliding-window-maximum">239. Sliding Window Maximum</a></h2>

<p>You are given an array of integers&nbsp;<code>nums</code>, there is a sliding window of size <code>k</code> which is moving from the very left of the array to the very right. You can only see the <code>k</code> numbers in the window. Each time the sliding window moves right by one position.</p>

<p>Return <em>the max sliding window</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,3,-1,-3,5,3,6,7], k = 3
<strong>Output:</strong> [3,3,5,5,6,7]
<strong>Explanation:</strong> 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       <strong>3</strong>
 1 [3  -1  -3] 5  3  6  7       <strong>3</strong>
 1  3 [-1  -3  5] 3  6  7      <strong> 5</strong>
 1  3  -1 [-3  5  3] 6  7       <strong>5</strong>
 1  3  -1  -3 [5  3  6] 7       <strong>6</strong>
 1  3  -1  -3  5 [3  6  7]      <strong>7</strong>
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1], k = 1
<strong>Output:</strong> [1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>4</sup> &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
	<li><code>1 &lt;= k &lt;= nums.length</code></li>
</ul>


---

# 🛍️ Sliding-Window-Maximum | Explained

## Approach 1 (Prefix and Suffix Arrays)
### Intuition
The idea behind this approach is to divide the problem into two parts: finding the maximum element in the prefix and suffix of the window. The prefix array will store the maximum element seen so far from the beginning of the array, while the suffix array will store the maximum element seen so far from the end of the array. By considering the maximum of the prefix and suffix at each position, we can determine the maximum element in the sliding window.

### Approach
The algorithm works as follows:
1. Create two arrays, `pref` and `suff`, to store the maximum prefix and suffix values respectively.
2. Fill the `pref` array by iterating through the input array from left to right. At each position `i`, if `i` is a multiple of the window size `k`, set `pref[i]` to the current element. Otherwise, set `pref[i]` to the maximum of the previous prefix value and the current element.
3. Fill the `suff` array by iterating through the input array from right to left. At each position `i`, if `i` is a position just before a multiple of the window size `k`, set `suff[i]` to the current element. Otherwise, set `suff[i]` to the maximum of the next suffix value and the current element.
4. Create an output array `ans` and fill it by taking the maximum of the corresponding suffix and prefix values at each position `i`.

### Detailed Code Analysis
Let's break down the code:
- Lines 3-4: Two arrays `pref` and `suff` are created to store the maximum prefix and suffix values respectively.
- Lines 6-10: The `pref` array is filled by iterating through the input array from left to right. The line `if (i % k == 0) pref[i] = nums[i];` checks if the current position `i` is a multiple of the window size `k`. If it is, the current element is set as the prefix value. Otherwise, the prefix value is set to the maximum of the previous prefix value and the current element.
- Lines 12-20: The `suff` array is filled by iterating through the input array from right to left. The line `if ((i + 1) % k == 0) suff[i] = nums[i];` checks if the current position `i` is just before a multiple of the window size `k`. If it is, the current element is set as the suffix value. Otherwise, the suffix value is set to the maximum of the next suffix value and the current element.
- Lines 22-25: The output array `ans` is filled by taking the maximum of the corresponding suffix and prefix values at each position `i`.
- Line 24: The line `ans[i] = Math.max(suff[i], pref[i + k - 1]);` calculates the maximum element in the sliding window at position `i`.

### Code
```java
int pref[] = new int[nums.length];
int suff[] = new int[nums.length];

for(int i = 0; i < nums.length; i++){
    if(i % k == 0) pref[i] = nums[i];
    else{
        pref[i] = Math.max(pref[i - 1], nums[i]);
    }
}

suff[nums.length - 1] = nums[nums.length - 1];
for(int i = nums.length - 2; i >= 0; i--){
    if((i + 1) % k == 0){
        suff[i] = nums[i];
    }else{
        suff[i] = Math.max(suff[i + 1], nums[i]);
    }
}

int ans[] = new int[nums.length - k + 1];
for(int i = 0; i < ans.length; i++){
    ans[i] = Math.max(suff[i], pref[i + k - 1]);
}
```

### Complexity
- Time: The time complexity of this solution is O(n), where n is the length of the input array. This is because we are iterating through the input array three times: once to fill the `pref` array, once to fill the `suff` array, and once to fill the output array `ans`.
- Space: The space complexity of this solution is O(n), where n is the length of the input array. This is because we are creating three arrays of the same length as the input array: `pref`, `suff`, and `ans`.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. **How would you optimize this solution to use less space?**: One way to optimize this solution is to use a deque to keep track of the maximum element in the sliding window, rather than creating separate arrays for the prefix and suffix values.
2. **How would you modify this solution to find the minimum element in the sliding window?**: To modify this solution to find the minimum element in the sliding window, you would simply need to replace the `Math.max` function calls with `Math.min` function calls, and update the logic accordingly.