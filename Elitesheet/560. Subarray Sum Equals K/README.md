<h2><a href="https://leetcode.com/problems/subarray-sum-equals-k">560. Subarray Sum Equals K</a></h2>

<p>Given an array of integers <code>nums</code> and an integer <code>k</code>, return <em>the total number of subarrays whose sum equals to</em> <code>k</code>.</p>

<p>A subarray is a contiguous <strong>non-empty</strong> sequence of elements within an array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [1,1,1], k = 2
<strong>Output:</strong> 2
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [1,2,3], k = 3
<strong>Output:</strong> 2
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 2 * 10<sup>4</sup></code></li>
	<li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li>
	<li><code>-10<sup>7</sup> &lt;= k &lt;= 10<sup>7</sup></code></li>
</ul>


---

# 🛍️ Subarray-Sum-Equals-K | Explained

## Approach 1 (Optimized)
### Intuition
The core idea behind this approach is to utilize a hashmap to store the cumulative sum of elements in the array and their frequencies. This approach is based on the concept that if the cumulative sum at index `j` is `sum`, and the cumulative sum at index `i` is `sum - k`, then the sum of the subarray from `i+1` to `j` is `k`. This idea works because it allows us to efficiently calculate the number of subarrays with sum equal to `k` by looking up the frequency of `sum - k` in the hashmap.

### Approach
1. Initialize a hashmap to store the cumulative sum and its frequency.
2. Initialize variables to store the cumulative sum and the answer (number of subarrays with sum equal to `k`).
3. Iterate through the array, updating the cumulative sum and frequency in the hashmap.
4. For each cumulative sum, check if `sum - k` exists in the hashmap. If it does, increment the answer by the frequency of `sum - k`.

### Detailed Code Analysis
The provided code implements this approach using the following key components:
- `sum`: Stores the cumulative sum of elements in the array.
- `ans`: Stores the number of subarrays with sum equal to `k`.
- `map`: A hashmap that stores the cumulative sum and its frequency.

Here's a line-by-line explanation:
- `map.put(0,1)`: Initializes the hashmap with a cumulative sum of `0` and a frequency of `1`. This is because the cumulative sum at index `-1` is `0`, and there is one such occurrence.
- `sum += nums[j]`: Updates the cumulative sum by adding the current element.
- `if(map.containsKey(sum -k))`: Checks if `sum - k` exists in the hashmap.
- `ans += map.get(sum-k)`: If `sum - k` exists, increments the answer by the frequency of `sum - k`.
- `map.put(sum,map.getOrDefault(sum,0)+1)`: Updates the frequency of the current cumulative sum in the hashmap.

### Code
```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int j=0;j<nums.length;j++){
            sum += nums[j];
            if(map.containsKey(sum -k)){
                ans += map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}
```

### Complexity
- Time: The time complexity of this approach is **O(n)**, where **n** is the length of the input array `nums`. This is because we make a single pass through the array, and each operation (hashmap lookup and update) takes constant time on average.
- Space: The space complexity of this approach is **O(n)**, as in the worst-case scenario (when all cumulative sums are distinct), we may store up to **n** entries in the hashmap.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some potential follow-up questions for this problem include:
- How would you modify the solution to find the maximum-length subarray with sum equal to `k`?
- What if the input array is very large and doesn't fit into memory? How would you modify the solution to handle this case? 

Brief answers:
- To find the maximum-length subarray with sum equal to `k`, we can modify the solution to store the start index of each cumulative sum in the hashmap, and then update the answer based on the length of the subarray.
- If the input array is too large to fit into memory, we can use a streaming or chunking approach to process the array in chunks, and use a similar hashmap-based approach to find the number of subarrays with sum equal to `k` within each chunk. The results can then be combined to get the final answer.