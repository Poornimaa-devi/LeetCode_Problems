<h2><a href="https://leetcode.com/problems/excel-sheet-column-title">168. Excel Sheet Column Title</a></h2>

<p>Given an integer <code>columnNumber</code>, return <em>its corresponding column title as it appears in an Excel sheet</em>.</p>

<p>For example:</p>

<pre>A -&gt; 1
B -&gt; 2
C -&gt; 3
...
Z -&gt; 26
AA -&gt; 27
AB -&gt; 28 
...
</pre>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> columnNumber = 1
<strong>Output:</strong> "A"
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> columnNumber = 28
<strong>Output:</strong> "AB"
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> columnNumber = 701
<strong>Output:</strong> "ZY"
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= columnNumber &lt;= 2<sup>31</sup> - 1</code></li>
</ul>


---

# 🛍️ Excel-Sheet-Column-Title | Explained

## Approach 1: Base-26 Conversion
### Intuition
The Excel-Sheet-Column-Title problem can be solved using a base-26 conversion approach. In this context, think of the column titles as a base-26 number system where 'A' represents 1, 'B' represents 2, and so on, up to 'Z' representing 26. This approach works because the given column numbers can be directly mapped to their corresponding base-26 representations, which are the Excel column titles.

### Algorithm Visualized
```mermaid
graph LR;
    A[Column Number] -->|minus 1|> B[Adjusted Column Number];
    B -->|mod 26|> C[Remainder];
    C -->|to char ('A' + remainder)|> D[Column Title Character];
    B -->|divide by 26|> E[Quotient];
    E -->|repeat|> B;
```

### Approach
The algorithm starts by taking the input column number and repeatedly applying the modulo operator with 26 to find the remainder. This remainder is then converted to its corresponding character ('A' + remainder). The quotient obtained by dividing the adjusted column number by 26 is used for the next iteration until the quotient becomes 0. This process is similar to converting a decimal number to another base.

### Detailed Code Analysis
The provided code snippet implements the base-26 conversion approach. Here's a line-by-line analysis:
- Line 3: A `StringBuilder` object named `result` is created to store the characters of the column title. `StringBuilder` is chosen for efficiency because it allows appending characters without creating a new string object in each iteration.
- Line 4: A while loop is used, which continues as long as `columnNumber` is greater than 0.
- Line 5: `columnNumber--` decrements the column number by 1. This adjustment is necessary because the base-26 system used in Excel column titles is 1-indexed (i.e., 'A' corresponds to 1, not 0).
- Line 6: `int temp = columnNumber % 26;` calculates the remainder of `columnNumber` divided by 26, which corresponds to the last character in the base-26 representation.
- Line 7: `result.append((char)('A' + temp));` converts the remainder to its corresponding character by adding it to the ASCII value of 'A' and appends it to the `result`.
- Line 8: `columnNumber /= 26;` updates `columnNumber` by performing integer division by 26, effectively removing the last digit in the base-26 representation.
- Line 10: After the loop ends, `result.reverse().toString()` is called to reverse the string and convert it to a format that can be returned. This is necessary because the characters were appended in reverse order during the calculation process.

### Code
```java
public String convertToTitle(int columnNumber) {
    StringBuilder result = new StringBuilder();
    while(columnNumber > 0){
        columnNumber--;
        int temp = columnNumber % 26;
        result.append((char)('A' + temp));
        columnNumber /= 26;
    }
    return result.reverse().toString();
}
```

### Complexity
- **Time:** The time complexity of this solution is O(log n), where n is the input column number. This is because the number of iterations in the while loop is directly proportional to the number of digits in the base-26 representation of the column number, which is logarithmic in the size of the input.
- **Space:** The space complexity is O(log n) as well, due to the space required to store the `result` string. The length of the `result` string is equal to the number of characters in the column title, which, as mentioned, is logarithmic in the size of the input column number.

## 🕵️‍♂️ Follow-up Questions
1. How would you modify this solution to convert an Excel column title back to a column number?
   - Answer: You can achieve this by iterating through the characters of the column title, converting each character back to its corresponding number (A=1, B=2, ..., Z=26), and then multiplying this number by 26 raised to the power of its position (counting from right to left and starting at 0), summing up these products to obtain the column number.
2. What if the input column number is very large, potentially exceeding the limit of an integer?
   - Answer: For very large inputs, you would need to use a data type that can handle larger numbers, such as `long` in Java, or consider using a library that supports arbitrary-precision arithmetic to avoid overflow issues. Additionally, ensuring that the input and output formats are properly defined and communicated is crucial in such scenarios.