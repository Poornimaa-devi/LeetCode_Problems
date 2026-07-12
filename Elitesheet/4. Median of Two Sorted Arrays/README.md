<h2><a href="https://leetcode.com/problems/median-of-two-sorted-arrays">4. Median of Two Sorted Arrays</a></h2>

<p>Given two sorted arrays <code>nums1</code> and <code>nums2</code> of size <code>m</code> and <code>n</code> respectively, return <strong>the median</strong> of the two sorted arrays.</p>

<p>The overall run time complexity should be <code>O(log (m+n))</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums1 = [1,3], nums2 = [2]
<strong>Output:</strong> 2.00000
<strong>Explanation:</strong> merged array = [1,2,3] and median is 2.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums1 = [1,2], nums2 = [3,4]
<strong>Output:</strong> 2.50000
<strong>Explanation:</strong> merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>nums1.length == m</code></li>
	<li><code>nums2.length == n</code></li>
	<li><code>0 &lt;= m &lt;= 1000</code></li>
	<li><code>0 &lt;= n &lt;= 1000</code></li>
	<li><code>1 &lt;= m + n &lt;= 2000</code></li>
	<li><code>-10<sup>6</sup> &lt;= nums1[i], nums2[i] &lt;= 10<sup>6</sup></code></li>
</ul>


---

# 🛍️ Median-of-Two-Sorted-Arrays | Explained

## Approach 1 (Merging Sorted Arrays)
### Intuition
The core idea behind this approach is to merge the two sorted arrays into a single sorted array, and then find the median of the resulting array. This works because the median of a sorted array is the middle element (or the average of the two middle elements if the array has an even number of elements). Think of it like combining two sets of exam scores, one from each class, and then finding the middle score of the combined set.

### Approach
The algorithmic steps are:
1. Calculate the total length of the two input arrays.
2. Create a new array to store the merged result.
3. Iterate through both input arrays, comparing elements and adding the smaller one to the new array.
4. If one array is exhausted before the other, append the remaining elements from the non-exhausted array to the new array.
5. Finally, calculate the median of the new array based on its length.

### Detailed Code Analysis
Let's dive into the code:
- Lines 3-5 calculate the lengths of the input arrays `nums1` and `nums2`, and the total length `n` of the merged array.
- Line 6 creates a new array `new_arr` to store the merged result.
- Lines 8-10 initialize indices `i`, `j`, and `k` to 0, which will be used to traverse `nums1`, `nums2`, and `new_arr`, respectively.
- The while loop (lines 10-24) compares elements from `nums1` and `nums2` and adds the smaller one to `new_arr`. If one array is exhausted, the remaining elements from the other array are appended to `new_arr`.
- Lines 26-27 calculate the median of `new_arr` based on its length. If the length is even, the median is the average of the two middle elements. If the length is odd, the median is the middle element.

### Code
```java
int n1 = nums1.length;
int n2 = nums2.length;
int n = n1 + n2;
int[] new_arr = new int[n];

int i=0, j=0, k=0;

while (i<=n1 && j<=n2) {
    if (i == n1) {
        while(j<n2) new_arr[k++] = nums2[j++];
        break;
    } else if (j == n2) {
        while (i<n1) new_arr[k++] = nums1[i++];
        break;
    }

    if (nums1[i] < nums2[j]) {
        new_arr[k++] = nums1[i++];
    } else {
        new_arr[k++] = nums2[j++];
    }
}

if (n%2==0) return (float)(new_arr[n/2-1] + new_arr[n/2])/2;
else return new_arr[n/2];
```

### Complexity
- Time: The time complexity is O(n + m), where n and m are the lengths of the input arrays. This is because we are scanning both arrays once to merge them, and then calculating the median.
- Space: The space complexity is O(n + m) as well, because we are creating a new array to store the merged result.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some possible follow-up questions and brief answers:
1. **Q: Can we improve the space complexity?**
A: Yes, instead of creating a new array, we can find the median in-place by comparing elements from the two input arrays and counting the number of elements less than or equal to the current element. This approach would have a space complexity of O(1).
2. **Q: What if the input arrays are very large and don't fit in memory?**
A: In that case, we would need to use a different approach that doesn't require loading the entire arrays into memory at once. One possible solution would be to use a streaming algorithm that processes the arrays in chunks, merging them on the fly and calculating the median as we go.