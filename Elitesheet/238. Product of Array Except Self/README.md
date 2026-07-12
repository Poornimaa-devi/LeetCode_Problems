<h2><a href="https://leetcode.com/problems/product-of-array-except-self">238. Product of Array Except Self</a></h2>

<p>Given an integer array <code>nums</code>, return <em>an array</em> <code>answer</code> <em>such that</em> <code>answer[i]</code> <em>is equal to the product of all the elements of</em> <code>nums</code> <em>except</em> <code>nums[i]</code>.</p>

<p>The product of any prefix or suffix of <code>nums</code> is <strong>guaranteed</strong> to fit in a <strong>32-bit</strong> integer.</p>

<p>You must write an algorithm that runs in&nbsp;<code>O(n)</code>&nbsp;time and without using the division operation.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [1,2,3,4]
<strong>Output:</strong> [24,12,8,6]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [-1,1,0,-3,3]
<strong>Output:</strong> [0,0,9,0,0]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-30 &lt;= nums[i] &lt;= 30</code></li>
	<li>The input is generated such that <code>answer[i]</code> is <strong>guaranteed</strong> to fit in a <strong>32-bit</strong> integer.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong>&nbsp;Can you solve the problem in <code>O(1)</code>&nbsp;extra&nbsp;space complexity? (The output array <strong>does not</strong> count as extra space for space complexity analysis.)</p>


---

# 🛍️ Product-of-Array-Except-Self | Explained

## Approach 1 (Optimized)
### Intuition
The core idea behind this approach is to utilize the concept of prefix and suffix products to calculate the product of all numbers in the array except for each individual number. This approach works by first calculating the prefix product (i.e., the product of all numbers up to a certain index) and storing it in the result array. Then, it calculates the suffix product (i.e., the product of all numbers after a certain index) and multiplies it with the corresponding prefix product in the result array. This way, each element in the result array will be the product of all numbers in the array except for the number at the corresponding index. The analogy for this approach is to think of it as two "waves" of product calculation - one going from left to right (prefix) and the other going from right to left (suffix).

### Approach
The algorithm can be broken down into the following steps:
1. Initialize the result array with the same length as the input array.
2. Calculate the prefix product by iterating through the input array from left to right and storing the product in the result array.
3. Calculate the suffix product by iterating through the input array from right to left and multiplying it with the corresponding prefix product in the result array.
4. Return the result array.

### Detailed Code Analysis
The provided code implements this approach with the following key points:
- The variable `n` is used to store the length of the input array `nums`.
- The result array `result` is initialized with the same length as the input array.
- The prefix product is calculated in the first for loop (lines 10-12), where `result[i]` is assigned the product of `result[i-1]` and `nums[i-1]`. This is done to ensure that `result[i]` stores the product of all numbers up to index `i-1`.
- A variable `right` is used to store the suffix product. It is initialized to 1 and updated in the second for loop (lines 17-20).
- In the second for loop, the suffix product is calculated and multiplied with the corresponding prefix product in the result array. The `right` variable is updated by multiplying it with `nums[i]`.
- The result array is returned at the end of the function.

### Code
```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        result[0] = 1;

        for(int i = 1; i < n; i++){
            result[i] = result[i-1] * nums[i-1];
        }

        int right = 1;

        for(int i = n-1; i >= 0; i--){
            result[i] = result[i] * right;
            right *= nums[i];
        }

        return result;
    }
}
```

### Complexity
- Time: The time complexity of this approach is O(n), where n is the length of the input array. This is because we are iterating through the array twice - once for the prefix product and once for the suffix product. Each iteration takes O(n) time, resulting in a total time complexity of O(n) + O(n) = O(2n), which simplifies to O(n).
- Space: The space complexity of this approach is O(1), excluding the space required for the output array. This is because we are using a constant amount of space to store the `right` variable and other variables, regardless of the size of the input array.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this pattern include:
- What if the input array contains zeros? How would you handle this case?
  - Answer: If the input array contains zeros, the product of all numbers except for the zero will be zero. Therefore, we need to handle this case separately and return an array with zeros, except for the indices where the input array contains zeros.
- How would you optimize the space complexity of the solution?
  - Answer: We are already using O(1) space excluding the output array. However, if we wanted to further optimize the space complexity, we could use the input array itself to store the prefix and suffix products, instead of using a separate result array. This would eliminate the need for extra space.