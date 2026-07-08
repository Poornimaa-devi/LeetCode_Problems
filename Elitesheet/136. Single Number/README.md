<h2><a href="https://leetcode.com/problems/single-number">136. Single Number</a></h2>

<p>Given a <strong>non-empty</strong>&nbsp;array of integers <code>nums</code>, every element appears <em>twice</em> except for one. Find that single one.</p>

<p>You must&nbsp;implement a solution with a linear runtime complexity and use&nbsp;only constant&nbsp;extra space.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [2,2,1]</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [4,1,2,1,2]</span></p>

<p><strong>Output:</strong> <span class="example-io">4</span></p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1]</span></p>

<p><strong>Output:</strong> <span class="example-io">1</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>-3 * 10<sup>4</sup> &lt;= nums[i] &lt;= 3 * 10<sup>4</sup></code></li>
	<li>Each element in the array appears twice except for one element which appears only once.</li>
</ul>


---

# 🛍️ Single-Number | Explained

## Approach 1: Bitwise XOR Operation
### Intuition
The idea behind this approach is to utilize the properties of the bitwise XOR operation. In simple terms, XOR returns 1 if the two bits are different, and 0 if they are the same. Think of it like a light switch - if you flip it an even number of times, it ends up in its original state. This can be used to find the single number in an array where all other numbers appear twice, as all the numbers that appear twice will "cancel each other out" when performing XOR operations.
### Approach
1. Initialize a variable `result` to 0.
2. Iterate over each number in the input array.
3. For each number, perform a bitwise XOR operation with the current `result`.
4. After iterating over all numbers, the `result` will be the single number that appears only once.
### Code
```java
int result = 0;
for(int num : nums) {
    result ^= num;
}
return result;
```
This code snippet is identical to the provided solution:
```java
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for(int num:nums){
            result ^=num;
        }
        return result;
    }
}
```
### Complexity
- Time: **O(n)**, where n is the number of elements in the input array, as we only iterate over the array once.
- Space: **O(1)**, as we use a constant amount of space to store the result, regardless of the input size.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this pattern could be:
- What if the array is very large and doesn't fit in memory? 
  - In this case, we could consider using a hashmap to store the counts of each number, but this would increase the space complexity. Another approach would be to use a database or a file-based approach to process the array in chunks.
- How would you extend this solution to find the single number in an array where all other numbers appear three times?
  - To solve this, we would need to use a different approach, such as using a hashmap to count the occurrences of each number, or using bitwise operations with two variables to track the bits that appear once and twice.