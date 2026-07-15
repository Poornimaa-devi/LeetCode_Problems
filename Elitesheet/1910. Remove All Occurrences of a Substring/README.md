<h2><a href="https://leetcode.com/problems/remove-all-occurrences-of-a-substring">1910. Remove All Occurrences of a Substring</a></h2>

<p>Given two strings <code>s</code> and <code>part</code>, perform the following operation on <code>s</code> until <strong>all</strong> occurrences of the substring <code>part</code> are removed:</p>

<ul>
	<li>Find the <strong>leftmost</strong> occurrence of the substring <code>part</code> and <strong>remove</strong> it from <code>s</code>.</li>
</ul>

<p>Return <code>s</code><em> after removing all occurrences of </em><code>part</code>.</p>

<p>A <strong>substring</strong> is a contiguous sequence of characters in a string.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "daabcbaabcbc", part = "abc"
<strong>Output:</strong> "dab"
<strong>Explanation</strong>: The following operations are done:
- s = "da<strong><u>abc</u></strong>baabcbc", remove "abc" starting at index 2, so s = "dabaabcbc".
- s = "daba<strong><u>abc</u></strong>bc", remove "abc" starting at index 4, so s = "dababc".
- s = "dab<strong><u>abc</u></strong>", remove "abc" starting at index 3, so s = "dab".
Now s has no occurrences of "abc".
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "axxxxyyyyb", part = "xy"
<strong>Output:</strong> "ab"
<strong>Explanation</strong>: The following operations are done:
- s = "axxx<strong><u>xy</u></strong>yyyb", remove "xy" starting at index 4 so s = "axxxyyyb".
- s = "axx<strong><u>xy</u></strong>yyb", remove "xy" starting at index 3 so s = "axxyyb".
- s = "ax<strong><u>xy</u></strong>yb", remove "xy" starting at index 2 so s = "axyb".
- s = "a<strong><u>xy</u></strong>b", remove "xy" starting at index 1 so s = "ab".
Now s has no occurrences of "xy".
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 1000</code></li>
	<li><code>1 &lt;= part.length &lt;= 1000</code></li>
	<li><code>s</code>​​​​​​ and <code>part</code> consists of lowercase English letters.</li>
</ul>


---

# 🛍️ Remove-All-Occurrences-of-a-Substring | Explained

## Approach 1 (Stack-Based)
### Intuition
Imagine you're editing a document and want to remove all occurrences of a specific phrase. You would start reading the document from the beginning, and whenever you encounter the phrase, you would skip over it and continue reading from the end of the phrase. This approach works because it effectively "skips" over the unwanted substring, allowing us to build the result string without the target substring.

### Approach
The algorithm starts by converting the input string `s` to a character array `input`. It also converts the target substring `part` to a character array `target`. The approach uses a stack `resultStack` to build the result string. It iterates over each character in the `input` array, and for each character, it checks if the current character matches the last character of the `target` array. If it does, it checks if the substring ending at the current position matches the `target` substring. If it matches, it skips over the `target` substring.

### Detailed Code Analysis
The code starts by initializing a `resultStack` array with the same length as the `input` array. It also initializes two variables: `stackSize` to keep track of the number of characters in the `resultStack`, and `targetLength` to store the length of the `target` substring. The `targetEndChar` variable stores the last character of the `target` substring.

 Inside the loop, the code checks each character in the `input` array. However, the provided code seems incomplete, and some parts are not in the correct order. Assuming the corrected version, it should be:

- Initialize `resultStack`, `stackSize`, `targetLength`, `input`, and `target`.
- Iterate over each character in `input`.
- For each character, if it's not part of the `target` substring, push it onto the `resultStack`.
- If the current character matches the last character of `target`, check if the substring ending at the current position matches `target`. If it matches, skip over `target`.

The provided code snippet seems to be missing some parts, but the idea is to use a stack to build the result string and skip over the `target` substring whenever it's encountered.

### Code
```java
public String removeOccurrences(String s, String part) {
    char[] input = s.toCharArray();
    char[] target = part.toCharArray();
    char[] resultStack = new char[input.length];
    int stackSize = 0;
    int targetLength = target.length;
    char targetEndChar = target[targetLength - 1];

    for (char currentChar : input) {
        // Check if currentChar is not part of the target substring
        // If not, push it onto the resultStack
        if (stackSize == 0 || currentChar != targetEndChar) {
            resultStack[stackSize++] = currentChar;
        } else {
            // Check if the substring ending at the current position matches target
            boolean match = true;
            for (int i = 0; i < targetLength; i++) {
                if (resultStack[stackSize - targetLength + i] != target[i]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                // Skip over the target substring
                stackSize -= targetLength;
            } else {
                // If not a match, push the current character onto the resultStack
                resultStack[stackSize++] = currentChar;
            }
        }
    }

    // Build the result string from the resultStack
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < stackSize; i++) {
        result.append(resultStack[i]);
    }

    return result.toString();
}
```

### Complexity
- Time: The time complexity is O(n*m), where n is the length of the input string `s` and m is the length of the target substring `part`. This is because in the worst-case scenario, we might need to check every character in `s` against every character in `part`.
- Space: The space complexity is O(n), where n is the length of the input string `s`. This is because we use a `resultStack` array of the same length as `s` to build the result string.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. Q: How would you optimize the solution for very large input strings?
A: To optimize the solution for very large input strings, you could use a more efficient string matching algorithm, such as the Knuth-Morris-Pratt (KMP) algorithm or the Rabin-Karp algorithm, to check for occurrences of the target substring.
2. Q: How would you modify the solution to remove all occurrences of multiple target substrings?
A: To modify the solution to remove all occurrences of multiple target substrings, you could use a loop to iterate over each target substring and apply the same removal logic. Alternatively, you could use a more advanced string matching algorithm that can handle multiple patterns, such as the Aho-Corasick algorithm.