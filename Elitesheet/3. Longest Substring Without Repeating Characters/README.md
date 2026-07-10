<h2><a href="https://leetcode.com/problems/longest-substring-without-repeating-characters">3. Longest Substring Without Repeating Characters</a></h2>

<p>Given a string <code>s</code>, find the length of the <strong>longest</strong> <span data-keyword="substring-nonempty" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_1l_" data-state="closed" class=""><strong>substring</strong></button></span> without duplicate characters.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "abcabcbb"
<strong>Output:</strong> 3
<strong>Explanation:</strong> The answer is "abc", with the length of 3. Note that <code>"bca"</code> and <code>"cab"</code> are also correct answers.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "bbbbb"
<strong>Output:</strong> 1
<strong>Explanation:</strong> The answer is "b", with the length of 1.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "pwwkew"
<strong>Output:</strong> 3
<strong>Explanation:</strong> The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= s.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>s</code> consists of English letters, digits, symbols and spaces.</li>
</ul>


---

# 🛍️ Longest-Substring-Without-Repeating-Characters | Explained

## Approach 1 (Optimized)
### Intuition
The core idea behind this approach is to use a sliding window technique in combination with a HashSet to efficiently track unique characters within the current substring. Imagine you are reading a string and have a magnifying glass that you move over the string, expanding or shrinking it as needed to include only unique characters. This is essentially what the sliding window does, with the HashSet acting as the tracker of unique characters within the window.

### Approach
The algorithm starts by initializing an empty HashSet to store unique characters and two pointers, `left` and `right`, to represent the sliding window. It then iterates over the string, expanding the window to the right by moving the `right` pointer. If a repeating character is found, it shrinks the window from the left by moving the `left` pointer until the repeating character is removed from the window. At each step, it updates the maximum length of the substring without repeating characters.

### Detailed Code Analysis
Let's dive into the code:
- Line 3: `HashSet<Character> set = new HashSet<>();` initializes an empty HashSet to store unique characters within the current window. A HashSet is chosen because it provides constant-time complexity for adding and checking if an element exists.
- Line 4: `int maxlen = 0;` initializes the maximum length of the substring without repeating characters found so far.
- Lines 5-6: `int left=0;` and `for(int right=0;right<s.length();right++)` set up the sliding window with `left` and `right` pointers.
- Line 7: `char ch = s.charAt(right);` gets the character at the current `right` position.
- The while loop (Lines 8-11) checks if the character `ch` is already in the set. If it is, it means we have a repeating character, so we remove the character at the `left` index from the set and increment `left` to shrink the window until the repeating character is removed.
- Line 12: `set.add(ch);` adds the current character to the set once we've ensured it's not a repeating character within the current window.
- Line 13: `maxlen = Math.max(maxlen,right-left+1);` updates the maximum length of the substring without repeating characters.

### Code
```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int maxlen = 0;
        int left=0;
        for(int right=0;right<s.length();right++){
            char ch = s.charAt(right);
            while(set.contains(ch)){ 
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            maxlen = Math.max(maxlen,right-left+1);
        }
        return maxlen;
    }
}
```

### Complexity
- Time: The time complexity is O(n), where n is the length of the string `s`. This is because each character in the string is visited at most twice (once by the `right` pointer and potentially once by the `left` pointer).
- Space: The space complexity is also O(n), as in the worst case (when all characters in the string are unique), the size of the HashSet `set` can grow up to the length of the string.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. **How would you handle the case when the input string is null or empty?** 
   - You can add a simple check at the beginning of the function to return 0 when the string is null or empty, as there's no substring in such cases.

2. **How would you modify the solution to find the actual longest substring without repeating characters, not just its length?** 
   - To find the actual longest substring, you can keep track of the starting and ending indices of the maximum substring found so far and return the substring using these indices. This requires adding variables to keep track of these indices and updating them whenever a new maximum length is found.