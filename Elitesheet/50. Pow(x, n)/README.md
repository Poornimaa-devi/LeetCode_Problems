<h2><a href="https://leetcode.com/problems/powx-n">50. Pow(x, n)</a></h2>

<p>Implement <a href="http://www.cplusplus.com/reference/valarray/pow/" target="_blank">pow(x, n)</a>, which calculates <code>x</code> raised to the power <code>n</code> (i.e., <code>x<sup>n</sup></code>).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> x = 2.00000, n = 10
<strong>Output:</strong> 1024.00000
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> x = 2.10000, n = 3
<strong>Output:</strong> 9.26100
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> x = 2.00000, n = -2
<strong>Output:</strong> 0.25000
<strong>Explanation:</strong> 2<sup>-2</sup> = 1/2<sup>2</sup> = 1/4 = 0.25
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>-100.0 &lt; x &lt; 100.0</code></li>
	<li><code>-2<sup>31</sup> &lt;= n &lt;= 2<sup>31</sup>-1</code></li>
	<li><code>n</code> is an integer.</li>
	<li>Either <code>x</code> is not zero or <code>n &gt; 0</code>.</li>
	<li><code>-10<sup>4</sup> &lt;= x<sup>n</sup> &lt;= 10<sup>4</sup></code></li>
</ul>


---

# 🛍️ Pow(x,-n) | Explained

## Approach 1 (Optimized)
### Intuition
The core idea behind this approach is to utilize the concept of exponentiation by squaring, a technique that reduces the number of multiplications required to calculate `x` raised to the power of `n`. This method works by iteratively squaring `x` and reducing `n` by half in each step, effectively reducing the problem size by half. Think of it like a game of chess, where you're making strategic moves (squaring `x`) and adjusting your approach (reducing `n`) to reach the final goal (calculating `x` to the power of `n`) in the fewest number of moves.

### Approach
The algorithmic breakdown involves the following high-level steps:
1. Check if the exponent `n` is negative and if so, convert the problem to a positive exponent by taking the reciprocal of `x`.
2. Initialize a variable `ans` to 1, which will store the final result.
3. Iterate through the bits of the exponent `n`, starting from the least significant bit.
4. If the current bit is 1, multiply `ans` by `x`.
5. In each iteration, square `x` to prepare for the next bit.
6. Repeat steps 3-5 until all bits of the exponent have been processed.

### Detailed Code Analysis
Let's dive into the code block:
```java
class Solution {
    public double myPow(double x, int n) {
        long exp = n; // Convert int to long to avoid overflow
        if (exp < 0) {
            x = 1 / x; // Take reciprocal of x if n is negative
            exp = -exp; // Convert n to positive
        }
        double ans = 1; // Initialize result to 1
        while (exp > 0) {
            if ((exp & 1) == 1) { // Check if current bit is 1
                ans *= x; // Multiply ans by x if bit is 1
            }
            x *= x; // Square x for next bit
            exp >>= 1; // Right shift exp by 1 bit (divide by 2)
        }
        return ans; // Return final result
    }
}
```
Here's a line-by-line breakdown:
- `long exp = n;` converts the `int` `n` to a `long` to avoid overflow for large values of `n`.
- The `if (exp < 0)` block checks if the exponent is negative and adjusts the problem accordingly by taking the reciprocal of `x` and converting `n` to positive.
- `double ans = 1;` initializes the result variable to 1.
- The `while (exp > 0)` loop iterates through the bits of the exponent `n`.
- Inside the loop, `if ((exp & 1) == 1)` checks the current bit of `exp`. If it's 1, `ans` is multiplied by `x`.
- `x *= x;` squares `x` for the next iteration, and `exp >>= 1;` right shifts `exp` by 1 bit, effectively dividing it by 2.
- The final result is returned after all bits have been processed.

### Code
```java
class Solution {
    public double myPow(double x, int n) {
        long exp = n; // Convert int to long to avoid overflow
        if (exp < 0) {
            x = 1 / x; // Take reciprocal of x if n is negative
            exp = -exp; // Convert n to positive
        }
        double ans = 1; // Initialize result to 1
        while (exp > 0) {
            if ((exp & 1) == 1) { // Check if current bit is 1
                ans *= x; // Multiply ans by x if bit is 1
            }
            x *= x; // Square x for next bit
            exp >>= 1; // Right shift exp by 1 bit (divide by 2)
        }
        return ans; // Return final result
    }
}
```

### Complexity
- Time: The time complexity is O(log n), where n is the absolute value of the exponent. This is because the number of iterations in the while loop is proportional to the number of bits in the binary representation of n, which is log n.
- Space: The space complexity is O(1), which means the space required does not grow with the size of the input. This is because only a constant amount of space is used to store the variables `exp`, `x`, and `ans`, regardless of the input size.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some potential follow-up questions for this problem could include:
1. How would you handle the case where `x` is 0 and `n` is negative? In this scenario, the function should throw an exception or return a special value to indicate an invalid input.
2. Can you optimize the solution for the case where `x` is 1 or -1? In these cases, the result can be determined directly without the need for the exponentiation by squaring algorithm.