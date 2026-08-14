<h2><a href="https://leetcode.com/problems/maximum-length-substring-with-two-occurrences">3090. Maximum Length Substring With Two Occurrences</a></h2>

Given a string <code>s</code>, return the <strong>maximum</strong> length of a <span data-keyword="substring" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_s_" data-state="closed" class="">substring</button></span>&nbsp;such that it contains <em>at most two occurrences</em> of each character.
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "bcbbbcba"</span></p>

<p><strong>Output:</strong> <span class="example-io">4</span></p>

<p><strong>Explanation:</strong></p>
The following substring has a length of 4 and contains at most two occurrences of each character: <code>"bcbb<u>bcba</u>"</code>.</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "aaaa"</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>
The following substring has a length of 2 and contains at most two occurrences of each character: <code>"<u>aa</u>aa"</code>.</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= s.length &lt;= 100</code></li>
	<li><code>s</code> consists only of lowercase English letters.</li>
</ul>


---

# 🛍️ Maximum-Length-Substring-With-Two-Occurrences | Explained

## Approach 1: Sliding Window with Frequency Tracking
### Intuition
The intuition behind this approach is to maintain a window of characters that have at most two occurrences. This can be compared to a real-world scenario where we have a container with a limited capacity, and we want to fill it with items (characters) such that each item appears at most twice. If an item appears more than twice, we need to remove the excess items from the container until the condition is met again.

### Algorithm Visualized
```mermaid
graph LR
    A[Start of String] -->|Initialize Frequency Array and Window Boundaries|> B[Scan String from Left to Right]
    B -->|Encounter Character|> C[Increment Frequency Count]
    C -->|Frequency Count > 2|> D[Slide Window to the Right]
    D -->|Update Maximum Length|> B
    B -->|End of String|> E[Return Maximum Length]
```

### Approach
The approach involves iterating over the string from left to right, maintaining a frequency count of each character within the current window. When a character's frequency exceeds 2, we slide the window to the right by moving the left boundary until the condition is met again. We keep track of the maximum length of the substring that satisfies the condition.

### Detailed Code Analysis
Let's break down the code step by step:
- `int[] freq = new int[26];`: This line initializes a frequency array `freq` of size 26, assuming that the input string only contains lowercase English letters. Each index in the array corresponds to a character in the alphabet (e.g., `freq[0]` corresponds to 'a', `freq[1]` corresponds to 'b', and so on).
- `int left = 0;`: This line initializes the left boundary of the sliding window to 0.
- `int maxLen = 0;`: This line initializes the maximum length of the substring to 0.
- `for (int right = 0; right < s.length(); right++)`: This loop iterates over the string from left to right, with `right` representing the current character index.
- `int idx = s.charAt(right) - 'a';`: This line calculates the index in the frequency array corresponding to the current character.
- `freq[idx]++;`: This line increments the frequency count of the current character in the frequency array.
- `while (freq[idx] > 2)`: This loop checks if the frequency count of the current character exceeds 2. If it does, the loop slides the window to the right by moving the left boundary.
- `freq[s.charAt(left) - 'a']--;`: This line decrements the frequency count of the character at the left boundary.
- `left++;`: This line moves the left boundary to the right.
- `maxLen = Math.max(maxLen, right - left + 1);`: This line updates the maximum length of the substring that satisfies the condition.

### Code
```java
public int maximumLengthSubstring(String s) {
    int[] freq = new int[26];
    int left = 0;
    int maxLen = 0;
    for (int right = 0; right < s.length(); right++) {
        int idx = s.charAt(right) - 'a';
        freq[idx]++;
        while (freq[idx] > 2) {
            freq[s.charAt(left) - 'a']--;
            left++;
        }
        maxLen = Math.max(maxLen, right - left + 1);
    }
    return maxLen;
}
```

### Complexity
- **Time:** The time complexity of this approach is O(n), where n is the length of the input string. This is because we make a single pass through the string, and each character is processed at most twice (once when we encounter it and once when we slide the window).
- **Space:** The space complexity of this approach is O(1), which means the space required does not grow with the size of the input string. This is because we use a fixed-size frequency array and a constant amount of space to store the window boundaries and the maximum length.