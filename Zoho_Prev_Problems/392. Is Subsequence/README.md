<h2><a href="https://leetcode.com/problems/is-subsequence">392. Is Subsequence</a></h2>

<p>Given two strings <code>s</code> and <code>t</code>, return <code>true</code><em> if </em><code>s</code><em> is a <strong>subsequence</strong> of </em><code>t</code><em>, or </em><code>false</code><em> otherwise</em>.</p>

<p>A <strong>subsequence</strong> of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., <code>"ace"</code> is a subsequence of <code>"<u>a</u>b<u>c</u>d<u>e</u>"</code> while <code>"aec"</code> is not).</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> s = "abc", t = "ahbgdc"
<strong>Output:</strong> true
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> s = "axc", t = "ahbgdc"
<strong>Output:</strong> false
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= s.length &lt;= 100</code></li>
	<li><code>0 &lt;= t.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s</code> and <code>t</code> consist only of lowercase English letters.</li>
</ul>

<p>&nbsp;</p>
<strong>Follow up:</strong> Suppose there are lots of incoming <code>s</code>, say <code>s<sub>1</sub>, s<sub>2</sub>, ..., s<sub>k</sub></code> where <code>k &gt;= 10<sup>9</sup></code>, and you want to check one by one to see if <code>t</code> has its subsequence. In this scenario, how would you change your code?

---

# 🛍️ Is-Subsequence | Explained

## Approach 1: Brute-Force Iterative Checking
### Intuition
The core idea behind this approach is to iterate through each character in string `t` and check if it matches any character in string `s`. If a match is found, the matched character is appended to a temporary string `abc`. After checking all characters in `t`, the approach checks if the constructed string `abc` is equal to `s` or if `abc` contains `s` as a substring.

### Algorithm Visualized
```mermaid
graph LR;
    A[Start] --> B[Initialize abc];
    B --> C[Iterate through t];
    C --> D[Check if t[i] == s[j]];
    D -->|Yes| E[Append t[i] to abc];
    D -->|No| C;
    E --> C;
    C -->|End of t| F[Check if abc == s or abc contains s];
    F -->|Yes| G[Return True];
    F -->|No| H[Return False];
```

### Approach
The algorithm starts by initializing an empty string `abc`. It then iterates through each character `t[i]` in string `t`. For each character in `t`, it checks every character `s[j]` in string `s`. If a match is found between `t[i]` and `s[j]`, it appends `t[i]` to the string `abc` and breaks the inner loop to move on to the next character in `t`. After iterating through all characters in `t`, it checks if the constructed string `abc` is equal to `s` or if `abc` contains `s` as a substring. If either condition is true, the function returns `True`; otherwise, it returns `False`.

### Detailed Code Analysis
The provided code starts by declaring a class `Solution` with a method `isSubsequence` that takes two parameters: `s` and `t`. Inside this method:
- It attempts to initialize a variable `abc` but does so incompletely, which would cause a compilation error. The intention seems to be initializing `abc` as an empty string (`""`).
- It uses two nested `for` loops. The outer loop iterates over each character in string `t` using `range(len(t))`, and the inner loop iterates over each character in string `s` using `range(len(s))`.
- Inside the inner loop, it checks if the current character of `s` (`s[j]`) matches the current character of `t` (`t[i]`). If they match, it appends `t[i]` to `abc` and breaks out of the inner loop using the `break` statement.
- After the loops, it checks two conditions: if `abc` is equal to `s` (`abc == s`), or if `abc` contains `s` as a substring (`abc.find(s) > 0`). However, this latter condition seems logically incorrect for the purpose of checking if `s` is a subsequence of `t`, as it should simply verify if the characters of `s` appear in `t` in the same order, not necessarily as a contiguous substring of `abc`.
- Finally, based on these conditions, it returns `True` if either condition is met, indicating that `s` is a subsequence of `t`, and `False` otherwise.

### Code
```python
class Solution(object):
    def isSubsequence(self, s, t):
        abc = ""
        for i in range(len(t)):
            for j in range(len(s)):
                if s[j] == t[i]:
                    abc += t[i]
                    break
        if abc == s or abc.find(s) > 0:
            return True
        else:
            return False
```

### Complexity
- **Time:** The time complexity of this approach is O(n*m), where n is the length of string `t` and m is the length of string `s`. This is because for each character in `t`, it potentially checks every character in `s`.
- **Space:** The space complexity is O(n), as in the worst-case scenario, the length of `abc` could be equal to the length of `t` if every character in `t` matches a character in `s`. However, the actual space complexity in the context of solving if `s` is a subsequence of `t` should be O(1), excluding the space needed for `s` and `t`, as we only need to keep track of the current position in `s` and `t`, not the entire sequence of matches.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. **How can this solution be optimized for better performance?**
   - The optimization would involve using a single pointer for `s` and iterating through `t`, checking each character in `t` against the current character in `s`, and moving the pointer in `s` forward only upon a match. This reduces the time complexity to O(n), where n is the length of `t`.
2. **What are the implications of the logical error in the condition `abc.find(s) > 0`?**
   - This condition is not necessary and introduces a logical error. The correct approach to verify if `s` is a subsequence of `t` should only check if all characters in `s` appear in `t` in the same order, which can be achieved by maintaining a pointer for `s` and moving it forward only when a match is found in `t`.