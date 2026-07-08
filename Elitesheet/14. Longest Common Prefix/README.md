<h2><a href="https://leetcode.com/problems/longest-common-prefix">14. Longest Common Prefix</a></h2>

<p>Write a function to find the longest common prefix string amongst an array of strings.</p>

<p>If there is no common prefix, return an empty string <code>""</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> strs = ["flower","flow","flight"]
<strong>Output:</strong> "fl"
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> strs = ["dog","racecar","car"]
<strong>Output:</strong> ""
<strong>Explanation:</strong> There is no common prefix among the input strings.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= strs.length &lt;= 200</code></li>
	<li><code>0 &lt;= strs[i].length &lt;= 200</code></li>
	<li><code>strs[i]</code> consists of only lowercase English letters if it is non-empty.</li>
</ul>


---

# 🛍️ Longest-Common-Prefix | Explained
The provided code solution is for the LeetCode problem "Longest-Common-Prefix". This problem involves finding the longest common prefix among all strings in a given array.

## Approach 1 (Iterative String Comparison)
### Intuition
The core idea behind this approach is to iteratively compare the strings in the array and find the common prefix. It's similar to how we would manually find the common prefix between two or more words, by comparing the characters at the same position in each word and stopping when we find a mismatch. This approach works because it takes advantage of the fact that the common prefix will be present in all strings, and by iteratively reducing the prefix length, we can effectively find the longest common prefix.

### Approach
The algorithmic breakdown of this approach is as follows:
1. Check if the input array is null or empty.
2. Initialize the prefix as the first string in the array.
3. Iterate over the remaining strings in the array.
4. For each string, check if it starts with the current prefix.
5. If it doesn't, reduce the prefix length by one character and repeat the check until the string starts with the prefix or the prefix becomes empty.
6. Once all strings have been checked, return the common prefix.

### Detailed Code Analysis
Let's dive into the code block:
- Line 3: `if (strs == null || strs.length == 0) {` checks if the input array is null or empty. If it is, the function returns without a value (although the return statement is missing a value, it should return an empty string to indicate no common prefix).
- Line 7: `String prefix = strs[0];` initializes the prefix as the first string in the array. This is the initial assumption for the common prefix.
- Line 8-15: The loop iterates over the remaining strings in the array. For each string, it checks if it starts with the current prefix using the `startsWith()` method.
- Line 10-11: If the string doesn't start with the prefix, the prefix length is reduced by one character using `prefix.substring(0, prefix.length() - 1)`. This is done in a while loop until the string starts with the prefix or the prefix becomes empty.
- Line 16: Finally, the function returns the common prefix after all strings have been checked.

### Code
```java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
}
```

### Complexity
- Time: The time complexity of this approach is O(n * m), where n is the number of strings in the array and m is the average length of the strings. This is because we're potentially iterating over each character in each string.
- Space: The space complexity is O(1), not including the space required for the input array and the output string. This is because we're only using a constant amount of space to store the prefix and other variables.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this problem could be:
1. How would you optimize this solution for very large input arrays?
   - Answer: You could optimize the solution by using a more efficient data structure, such as a trie, to store the strings and find the common prefix. However, for small to medium-sized input arrays, the existing solution is already efficient enough.
2. What if the input array contains null or empty strings?
   - Answer: The existing solution already handles null or empty input arrays by returning an empty string. However, it doesn't explicitly handle null or empty strings within the array. To handle this, you could add additional checks at the beginning of the function to ignore null or empty strings.