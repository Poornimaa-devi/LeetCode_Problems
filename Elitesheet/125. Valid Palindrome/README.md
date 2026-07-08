<h2><a href="https://leetcode.com/problems/valid-palindrome">125. Valid Palindrome</a></h2>

<p>A phrase is a <strong>palindrome</strong> if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.</p>

<p>Given a string <code>s</code>, return <code>true</code><em> if it is a <strong>palindrome</strong>, or </em><code>false</code><em> otherwise</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "A man, a plan, a canal: Panama"
<strong>Output:</strong> true
<strong>Explanation:</strong> "amanaplanacanalpanama" is a palindrome.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "race a car"
<strong>Output:</strong> false
<strong>Explanation:</strong> "raceacar" is not a palindrome.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = " "
<strong>Output:</strong> true
<strong>Explanation:</strong> s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 2 * 10<sup>5</sup></code></li>
	<li><code>s</code> consists only of printable ASCII characters.</li>
</ul>


---

# 🛍️ Valid-Palindrome | Explained

## Approach 1 (Optimized Two-Pointer Technique)
### Intuition
The core idea behind this approach is to use a two-pointer technique to compare characters from the start and end of the string, moving towards the center. This approach is efficient because it only requires a single pass through the string and handles non-alphanumeric characters by skipping them. It's similar to how you might compare two words by looking at their first and last letters, then moving inwards.

### Approach
The algorithm works by maintaining two pointers, one at the start and one at the end of the string. It compares the characters at these positions, ignoring any non-alphanumeric characters it encounters. If the characters are not equal (after converting to lowercase), the function immediately returns false. If the loop completes without finding any unequal pairs of characters, the function returns true, indicating that the string is a palindrome.

### Detailed Code Analysis
Let's break down the code line by line:
- `if(s.isEmpty()){ return true; }`: This checks if the input string is empty. An empty string is considered a palindrome, so the function returns true immediately.
- `int start=0;` and `int last=s.length()-1;`: These lines initialize the two pointers, `start` and `last`, to the beginning and end of the string, respectively.
- The `while(start<last)` loop continues as long as the `start` pointer is less than the `last` pointer, ensuring that we compare characters from the start and end of the string, moving towards the center.
- Inside the loop:
  - `char currfirst = s.charAt(start);` and `char currlast = s.charAt(last);`: These lines retrieve the characters at the current `start` and `last` positions.
  - The `if` and `else if` statements check if the current characters are non-alphanumeric using `Character.isLetterOrDigit()`. If either character is non-alphanumeric, the corresponding pointer is moved towards the center of the string.
  - If both characters are alphanumeric, `if(Character.toLowerCase(currfirst)!=Character.toLowerCase(currlast))` compares them (after converting to lowercase). If they are not equal, the function returns false.
  - If the characters are equal, both `start` and `last` pointers are moved towards the center of the string.
- Finally, if the loop completes without returning false, `return true;` indicates that the string is a palindrome.

### Code
```java
class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()){
            return true;
        }
        int start=0;
        int last=s.length()-1;
        while(start<last){
            char currfirst = s.charAt(start);
            char currlast = s.charAt(last);
            if(!Character.isLetterOrDigit(currfirst)){
                start++;
            }else if(!Character.isLetterOrDigit(currlast)){
                last--;
            }else{
                if(Character.toLowerCase(currfirst)!=Character.toLowerCase(currlast)){
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }
}
```

### Complexity
- Time: The time complexity is O(n), where n is the length of the string. This is because in the worst-case scenario, we might need to traverse the entire string once.
- Space: The space complexity is O(1), not counting the space needed for the input string. This is because we only use a constant amount of space to store the pointers and characters, regardless of the size of the input.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. **How would you handle non-English characters in this problem?**
   - The current implementation using `Character.isLetterOrDigit()` handles non-English alphanumeric characters correctly because it considers them as part of the possible alphanumeric set. However, if you need to ignore accents or consider non-English characters as non-alphanumeric (which is less common but could be a requirement in certain contexts), you might need to add additional handling, possibly using Unicode character properties.

2. **Can you optimize the solution further?**
   - The given solution is already quite optimized, with a linear time complexity. However, minor adjustments could be made for better readability or to handle edge cases more explicitly (e.g., null input strings), but these would not change the overall time or space complexity.