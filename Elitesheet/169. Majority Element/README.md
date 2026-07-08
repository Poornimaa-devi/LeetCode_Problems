<h2><a href="https://leetcode.com/problems/majority-element">169. Majority Element</a></h2>

<p>Given an array <code>nums</code> of size <code>n</code>, return <em>the majority element</em>.</p>

<p>The majority element is the element that appears more than <code>⌊n / 2⌋</code> times. You may assume that the majority element always exists in the array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [3,2,3]
<strong>Output:</strong> 3
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [2,2,1,1,1,2,2]
<strong>Output:</strong> 2
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 &lt;= n &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li>The input is generated such that a majority element will exist in the array.</li>
</ul>

<p>&nbsp;</p>
<strong>Follow-up:</strong> Could you solve the problem in linear time and in <code>O(1)</code> space?

---

# 🛍️ Majority-Element | Explained

## Approach 1: Boyer-Moore Voting Algorithm
### Intuition
The Boyer-Moore Voting Algorithm is a popular approach to solve the Majority-Element problem. Imagine you're at a concert, and you want to find the most popular song. You ask each person about their favorite song, and for each person who likes a different song, you subtract a point from the current favorite song. If the points reach zero, you switch to a new favorite song. The song that ends up with the most points (or never reaches zero) is likely the most popular one. This algorithm works under the assumption that a majority element exists.

### Approach
Here's a step-by-step breakdown of how the Boyer-Moore Voting Algorithm works:
1. Initialize a `candidate` variable with the first element of the array and a `count` variable to zero.
2. Iterate through each element in the array. If the `count` is zero, set the `candidate` to the current element.
3. For each element, increment the `count` if the element is the same as the `candidate`; otherwise, decrement the `count`.
4. After the iteration, the `candidate` variable will hold the majority element.

### Code
```java
int candidate = nums[0];
int count = 0;

for (int num : nums) {
    if (count == 0) {
        candidate = num;
    }
    count += (num == candidate) ? 1 : -1;
}

return candidate;
```

### Complexity
- Time: O(n), where n is the number of elements in the array, because we only iterate through the array once.
- Space: O(1), because we only use a constant amount of space to store the `candidate` and `count` variables.

## 🕵️‍♂️ Follow-up Questions
1. Q: What if there is no majority element in the array?
A: In this case, the Boyer-Moore Voting Algorithm may not work correctly. To handle this scenario, you can perform a second pass through the array to confirm that the `candidate` element indeed occurs more than n/2 times.
2. Q: Can this algorithm be used for finding the minority element (the element that occurs less than n/2 times)?
A: No, the Boyer-Moore Voting Algorithm is specifically designed to find the majority element (the element that occurs more than n/2 times). To find the minority element, you would need to use a different approach, such as sorting the array or using a hash table to count the occurrences of each element.