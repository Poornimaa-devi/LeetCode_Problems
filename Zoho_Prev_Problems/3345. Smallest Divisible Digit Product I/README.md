<h2><a href="https://leetcode.com/problems/smallest-divisible-digit-product-i">3345. Smallest Divisible Digit Product I</a></h2>

<p>You are given two integers <code>n</code> and <code>t</code>. Return the <strong>smallest</strong> number greater than or equal to <code>n</code> such that the <strong>product of its digits</strong> is divisible by <code>t</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 10, t = 2</span></p>

<p><strong>Output:</strong> <span class="example-io">10</span></p>

<p><strong>Explanation:</strong></p>

<p>The digit product of 10 is 0, which is divisible by 2, making it the smallest number greater than or equal to 10 that satisfies the condition.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 15, t = 3</span></p>

<p><strong>Output:</strong> <span class="example-io">16</span></p>

<p><strong>Explanation:</strong></p>

<p>The digit product of 16 is 6, which is divisible by 3, making it the smallest number greater than or equal to 15 that satisfies the condition.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 100</code></li>
	<li><code>1 &lt;= t &lt;= 10</code></li>
</ul>


---

# 🛍️ Smallest-Divisible-Digit-Product-I | Explained

## Approach 1: Brute-Force Iteration
### Intuition
The core idea of this approach is to continuously check each number to see if the product of its digits is divisible by the target number `t`. This is analogous to manually checking each product of digits for divisibility, similar to how one would check for divisibility in a long division problem. The approach works because it exhaustively checks each number until it finds one that meets the condition.

### Algorithm Visualized
Since this problem doesn't lend itself easily to a visual representation like a flowchart or state diagram due to its simplicity, we'll proceed directly to explaining the approach and diving into the code.

### Approach
The algorithm starts by checking the input number `n`. If the product of its digits is divisible by `t`, it returns `n`. Otherwise, it enters a loop where it presumably checks subsequent numbers. However, the provided code snippet seems incomplete and incorrectly structured, making it challenging to deduce the exact logic without assumptions.

### Detailed Code Analysis
Given the incomplete and improperly formatted code, let's attempt to decipher its intent. The method `digitproduct(int n)` likely calculates the product of the digits of `n`. For example:
- For `n = 123`, `digitproduct(n)` would return `1*2*3 = 6`.
The main method `smallestNumber(int n, int t)` checks if `digitproduct(n)` is divisible by `t`. If it is, `n` is returned. Otherwise, it seems intended to increment `n` and repeat the check, though the provided loop structure and conditional statements are incomplete or incorrect.

### Code
Given the issues with the provided code, let's construct a corrected version based on our understanding:
```java
class Solution {
    public int smallestNumber(int n, int t) {
        while (true) {
            int prod = digitproduct(n);
            if (prod % t == 0) return n;
            n++;
        }
    }
    
    public int digitproduct(int n) {
        int prod = 1;
        while (n > 0) {
            prod *= n % 10;
            n /= 10;
        }
        return prod;
    }
}
```
### Complexity
- **Time:** The time complexity of this solution depends on how many numbers need to be checked before finding one whose digit product is divisible by `t`. In the worst case, if no such number is found in a reasonable range, the time complexity could be considered O(inf) or, more realistically, O(k), where k is the number of iterations until a suitable number is found. However, given the specific nature of the problem, it's difficult to provide a precise bound without knowing more about `n` and `t`.
- **Space:** The space complexity is O(1) since the solution only uses a constant amount of space to store variables like `n`, `t`, and `prod`, regardless of the input size.

## Approach 2: None
There is no second approach discernible from the provided code snippet. The code appears to be an attempt at a brute-force solution but is incomplete and improperly structured. Thus, only one approach can be discussed based on the given information. 

## 🕵️‍♂️ Follow-up Questions (Optional)
1. **What if there are multiple smallest numbers whose digit product is divisible by `t`? Should we return the first one or all of them?**
   - The current implementation returns the first such number it encounters.
2. **How can we optimize this solution for very large inputs of `n` and `t`?**
   - Optimization would likely involve a more sophisticated algorithm than brute-force checking, potentially involving mathematical properties of numbers and divisibility.