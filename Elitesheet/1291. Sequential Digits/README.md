<h2><a href="https://leetcode.com/problems/sequential-digits">1291. Sequential Digits</a></h2>

<p>An&nbsp;integer has <em>sequential digits</em> if and only if each digit in the number is one more than the previous digit.</p>

<p>Return a <strong>sorted</strong> list of all the integers&nbsp;in the range <code>[low, high]</code>&nbsp;inclusive that have sequential digits.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> low = 100, high = 300
<strong>Output:</strong> [123,234]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> low = 1000, high = 13000
<strong>Output:</strong> [1234,2345,3456,4567,5678,6789,12345]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>10 &lt;= low &lt;= high &lt;= 10^9</code></li>
</ul>


---

# 🛍️ Sequential-Digits | Explained

## Approach 1 (Optimized)
### Intuition
The problem of finding sequential digits can be thought of as generating all possible numbers that have digits in sequential order, within a given range (low to high). This approach works by leveraging the fact that all sequential digits (from 1 to 9) can be represented as a single string ("123456789"). By iterating over possible substrings of this string with varying lengths, we can efficiently generate all sequential digits within the given range. It's like having a digital number pad where you start at a certain digit and keep pressing the next digit to form a sequence.

### Approach
The algorithm starts by initializing an empty list to store the answer. It then generates all possible sequential digits by iterating over the string of digits ("123456789") with two nested loops. The outer loop controls the length of the substring (i.e., the number of digits), while the inner loop controls the starting position of the substring. For each substring, it checks if the corresponding integer falls within the given range (low to high). If it does, the integer is added to the answer list.

### Detailed Code Analysis
Let's break down the code block:
- `String s = 123456789;`: This line initializes a string `s` containing all digits from 1 to 9. This string serves as the basis for generating all possible sequential digits.
- `String l = String.valueOf(low);` and `String h = String.valueOf(high);`: These lines convert the lower and upper bounds (`low` and `high`) into strings. This conversion allows us to easily determine the length of the bounds, which is crucial for the subsequent loop iterations.
- `for(int len=l.length();len<=h.length();len++){...}`: This outer loop iterates over all possible lengths of sequential digits, starting from the length of the lower bound (`low`) up to the length of the upper bound (`high`).
- `for(int start=0;start<=9-len;start++){...}`: This inner loop controls the starting position of the substring within the string `s`. The loop condition ensures that the substring's length (`len`) never exceeds the remaining characters in the string `s`, thus preventing `StringIndexOutOfBoundsException`.
- `int num = Integer.parseInt(s.substring(start,start+len));`: This line extracts a substring from `s` based on the current `start` position and length (`len`). The extracted substring is then converted into an integer using `Integer.parseInt`.
- `if(num>=low && num<=high){...}`: This conditional statement checks if the generated sequential digit (`num`) falls within the given range (`low` to `high`). If it does, the number is added to the answer list (`ans`).
### Code
```java
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans = new ArrayList<>();

        String s = "123456789";
        String l = String.valueOf(low);
        String h = String.valueOf(high);

        for(int len=l.length();len<=h.length();len++){
            for(int start=0;start<=9-len;start++){
                int num = Integer.parseInt(s.substring(start,start+len));
                if(num>=low && num<=high){
                    ans.add(num);
                }
            }
        }
        return ans;
    }
}
```
### Complexity
- Time: The time complexity of this approach is O(n), where n is the number of digits in the upper bound (`high`). To be more precise, it is O((h.length() - l.length() + 1) * (10 - h.length())). This is because the outer loop runs (h.length() - l.length() + 1) times, and the inner loop runs up to (10 - h.length()) times.
- Space: The space complexity is O(k), where k is the number of sequential digits in the given range. This is because we need to store all these sequential digits in the answer list (`ans`). In the worst case, k can be as large as O(n), where n is the number of digits in the upper bound (`high`).

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this pattern include:
1. What if the input range is very large? How would you optimize the solution to handle such cases?
Answer: To handle large input ranges, you can use a more efficient data structure, such as a `HashSet`, to store the generated sequential digits. This would eliminate duplicates and reduce the space complexity. Additionally, you can use multi-threading or parallel processing to generate sequential digits in parallel, further improving performance.
2. How would you extend this solution to generate sequential digits with a specific length (e.g., all 5-digit sequential digits)?
Answer: To generate sequential digits with a specific length, you can modify the outer loop to only iterate over the desired length. For example, to generate all 5-digit sequential digits, you can set the outer loop to run from 5 to 5 (`for(int len=5;len<=5;len++)`). This would ensure that only 5-digit sequential digits are generated.