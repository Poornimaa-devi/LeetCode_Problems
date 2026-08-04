<h2><a href="https://leetcode.com/problems/integer-to-english-words">273. Integer to English Words</a></h2>

<p>Convert a non-negative integer <code>num</code> to its English words representation.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> num = 123
<strong>Output:</strong> "One Hundred Twenty Three"
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> num = 12345
<strong>Output:</strong> "Twelve Thousand Three Hundred Forty Five"
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> num = 1234567
<strong>Output:</strong> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= num &lt;= 2<sup>31</sup> - 1</code></li>
</ul>


---

# 🛍️ Integer-to-English-Words | Explained

## Approach 1: Recursive Solution
### Intuition
The core idea behind this approach is to break down the number into smaller parts, such as ones, tens, hundreds, thousands, millions, and billions. This is similar to how we would naturally describe a number in English, by combining smaller units to form larger ones. For example, the number 1234 can be broken down into "one thousand two hundred thirty four". This approach works by recursively dividing the number into smaller parts and then combining the corresponding English words.

### Algorithm Visualized
```mermaid
graph LR
    A[Input Number] --> B{Is Number 0?}
    B -->|Yes| C[Return "Zero"]
    B -->|No| D{Is Number < 10?}
    D -->|Yes| E[Return Ones Array]
    D -->|No| F{Is Number < 20?}
    F -->|Yes| G[Return Below 20 Array]
    F -->|No| H{Is Number < 100?}
    H -->|Yes| I[Return Tens Array + Recursive Call]
    H -->|No| J{Is Number < 1000?}
    J -->|Yes| K[Return Hundreds Array + Recursive Call]
    J -->|No| L{Is Number < 1000000?}
    L -->|Yes| M[Return Thousands Array + Recursive Call]
    L -->|No| N{Is Number < 1000000000?}
    N -->|Yes| O[Return Millions Array + Recursive Call]
    N -->|No| P[Return Billions Array + Recursive Call]
```

### Approach
The algorithm starts by checking if the input number is 0. If it is, the function returns the string "Zero". Otherwise, it checks if the number is less than 10, in which case it returns the corresponding string from the ones array. If the number is greater than or equal to 10 but less than 20, it returns the corresponding string from the below 20 array. For numbers greater than or equal to 20 but less than 100, it returns the corresponding string from the tens array and then recursively calls the function with the remainder of the number. This process continues for numbers greater than or equal to 100, where the function returns the corresponding string from the hundreds, thousands, millions, or billions array, and then recursively calls the function with the remainder of the number.

### Detailed Code Analysis
The code starts by defining three static arrays: `ones`, `below20`, and `tens`, which contain the strings for numbers 1-9, 10-19, and 20-90, respectively. The `numberToWords` function takes an integer as input and checks if it is 0. If it is, the function returns the string "Zero". Otherwise, it calls the `solve` function with the input number. The `solve` function is a recursive function that breaks down the number into smaller parts and returns the corresponding English words. The `trim` function is used to remove any trailing whitespace from the result.

The `solve` function checks if the number is less than 10, and if so, returns the corresponding string from the `ones` array. If the number is less than 20, it returns the corresponding string from the `below20` array. For numbers greater than or equal to 20 but less than 100, it returns the corresponding string from the `tens` array and then recursively calls the `solve` function with the remainder of the number. This process continues for numbers greater than or equal to 100, where the function returns the corresponding string from the hundreds, thousands, millions, or billions array, and then recursively calls the `solve` function with the remainder of the number.

### Code
```java
class Solution {
    private static final String[] ones = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] below20 = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        return solve(num).trim();
    }

    private String solve(int num) {
        if (num < 10) return ones[num];
        if (num < 20) return below20[num - 10];
        if (num < 100) return (tens[num / 10] + " " + solve(num % 10)).trim();
        if (num < 1000) return (solve(num / 100) + " Hundred " + solve(num % 100)).trim();
        if (num < 1000000) return (solve(num / 1000) + " Thousand " + solve(num % 1000)).trim();
        if (num < 1000000000) return (solve(num / 1000000) + " Million " + solve(num % 1000000)).trim();
        return (solve(num / 1000000000) + " Billion " + solve(num % 1000000000)).trim();
    }
}
```

### Complexity
- **Time:** O(log n), where n is the input number. This is because the function recursively divides the number into smaller parts, and the number of recursive calls is proportional to the number of digits in the input number.
- **Space:** O(log n), where n is the input number. This is because the function uses a recursive approach, and the maximum depth of the recursion tree is proportional to the number of digits in the input number. The space complexity is also due to the use of the `trim` function, which creates a new string object. However, this overhead is negligible compared to the recursive function calls.