<h2><a href="https://leetcode.com/problems/reverse-words-in-a-string">151. Reverse Words in a String</a></h2>

<p>Given an input string <code>s</code>, reverse the order of the <strong>words</strong>.</p>

<p>A <strong>word</strong> is defined as a sequence of non-space characters. The <strong>words</strong> in <code>s</code> will be separated by at least one space.</p>

<p>Return <em>a string of the words in reverse order concatenated by a single space.</em></p>

<p><b>Note</b> that <code>s</code> may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "the sky is blue"
<strong>Output:</strong> "blue is sky the"
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "  hello world  "
<strong>Output:</strong> "world hello"
<strong>Explanation:</strong> Your reversed string should not contain leading or trailing spaces.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "a good   example"
<strong>Output:</strong> "example good a"
<strong>Explanation:</strong> You need to reduce multiple spaces between two words to a single space in the reversed string.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s</code> contains English letters (upper-case and lower-case), digits, and spaces <code>' '</code>.</li>
	<li>There is <strong>at least one</strong> word in <code>s</code>.</li>
</ul>

<p>&nbsp;</p>
<p><b data-stringify-type="bold">Follow-up:&nbsp;</b>If the string data type is mutable in your language, can&nbsp;you solve it&nbsp;<b data-stringify-type="bold">in-place</b>&nbsp;with&nbsp;<code data-stringify-type="code">O(1)</code>&nbsp;extra space?</p>


---

# 🛍️ Reverse-Words-in-a-String | Explained

Unfortunately, the provided code snippet appears to be incomplete and contains only fragments of a potential solution. However, I will attempt to analyze the given code and provide a detailed explanation of a potential approach that this code might be a part of.

## Approach 1 (Potential Solution)
### Intuition
The idea behind reversing words in a string is to identify each word in the string, reverse the order of these words, and then return the resulting string. This can be thought of as handling a string as a list of words where each word is an element in the list, and we simply reverse the order of elements in the list.

### Approach
1. Start from the end of the string and iterate backwards to identify each word.
2. When a word is found, append it to a StringBuilder object, which is used to efficiently build the resulting string.
3. If the word is not the first word in the resulting string, a space is appended before the word to separate it from the previous word.
4. Continue this process until all words have been processed, resulting in a string where the order of the words has been reversed.

### Detailed Code Analysis
The code provided seems to be a part of this approach. Let's analyze the key parts of the code:
- `int i = s.length() - 1;` This line initializes a variable `i` to the last index of the string `s`, which is where we start iterating from.
- `StringBuilder sb = new StringBuilder();` This line initializes a StringBuilder object `sb` that will be used to efficiently build the resulting string.
- `while (i >= 0 && s.charAt(i) != ' ')` This loop continues as long as `i` is within the bounds of the string and the current character at index `i` is not a space. This effectively finds the end of a word.
- `if (sb.length() > 0) { sb.append(' '); }` This checks if the StringBuilder is not empty, and if so, appends a space before appending a new word. This ensures words are separated by a space in the resulting string.

### Code
Given the incomplete nature of the provided code, let's attempt to fill in the gaps for a complete solution based on the above analysis:
```java
class Solution {
    public String reverseWords(String s) {
        int i = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            if (i < 0) break;
            int end = i;
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            if (sb.length() > 0) {
                sb.append(' ');
            }
            sb.append(s.substring(i + 1, end + 1));
        }
        return sb.toString();
    }
}
```

### Complexity
- Time: The time complexity of this solution is O(n), where n is the length of the input string `s`. This is because we are potentially scanning through the string once.
- Space: The space complexity is also O(n), as in the worst-case scenario, the StringBuilder `sb` will store a string of the same length as the input string `s`.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. **How would you handle the case where the input string is null or empty?**
   - You would typically check for these conditions at the beginning of the function and return an empty string or throw an exception as per the problem requirements.
2. **Can you optimize the solution to handle multiple consecutive spaces?**
   - The provided solution already handles this by skipping over consecutive spaces when moving backwards through the string.