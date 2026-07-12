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

## Approach 1: Hash Table Optimization
### Intuition
Imagine you are the manager of a warehouse where you store the cumulative sum of inventory values. Every time you receive a new shipment, you update the cumulative sum. If you have a target inventory value, you can quickly find out how many times you have had that exact value in the past by checking your warehouse records. This approach works by leveraging a hash table to store the cumulative sum of the array elements and their frequencies, allowing for efficient lookups and updates.

### Approach
The algorithmic approach can be broken down into the following steps:
1. Initialize a hash table to store the cumulative sum and its frequency.
2. Initialize the cumulative sum and the answer variable.
3. Iterate through the array, updating the cumulative sum at each step.
4. For each cumulative sum, check if the hash table contains the difference between the current cumulative sum and the target sum (k).
5. If the difference exists, increment the answer by the frequency of the difference in the hash table.
6. Update the frequency of the current cumulative sum in the hash table.
7. Return the answer, which represents the number of subarrays with a sum equal to k.

### Detailed Code Analysis
Let's dive into the code block line by line:
1. `int sum = 0;` initializes the cumulative sum variable to 0.
2. `int ans = 0;` initializes the answer variable to 0, which will store the number of subarrays with a sum equal to k.
3. `HashMap<Integer,Integer> map = new HashMap<>();` creates a hash table to store the cumulative sum and its frequency. The key represents the cumulative sum, and the value represents the frequency.
4. `map.put(0,1);` initializes the hash table with a cumulative sum of 0 and a frequency of 1. This is because an empty subarray has a sum of 0.
5. The `for` loop iterates through the array, updating the cumulative sum at each step: `sum += nums[j];`.
6. The `if` condition checks if the hash table contains the difference between the current cumulative sum and the target sum (k): `if(map.containsKey(sum -k))`.
7. If the difference exists, the answer is incremented by the frequency of the difference in the hash table: `ans += map.get(sum-k);`.
8. The frequency of the current cumulative sum is updated in the hash table: `map.put(sum,map.getOrDefault(sum,0)+1);`.
The hash table is used to store the cumulative sum and its frequency, allowing for efficient lookups and updates. The `getOrDefault` method is used to handle the case where the cumulative sum is not present in the hash table, in which case it defaults to 0.

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
- Time: The time complexity is O(n), where n is the length of the array. This is because we are iterating through the array once, and the hash table operations (put and get) have an average time complexity of O(1).
- Space: The space complexity is O(n), as in the worst case, we may need to store all cumulative sums in the hash table.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this pattern include:
1. How would you handle the case where the array is too large to fit into memory?
 Answer: You could consider using a more memory-efficient data structure, such as a trie, or processing the array in chunks.
2. How would you modify the solution to find the number of subarrays with a sum within a certain range (e.g., between k1 and k2)?
 Answer: You could modify the solution to use a range query data structure, such as a segment tree or a range tree, to efficiently find the number of cumulative sums within the desired range.