<h2><a href="https://leetcode.com/problems/valid-anagram">242. Valid Anagram</a></h2>

<p>Given two strings <code>s</code> and <code>t</code>, return <code>true</code> if <code>t</code> is an <span data-keyword="anagram" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_1l_" data-state="closed" class="">anagram</button></span> of <code>s</code>, and <code>false</code> otherwise.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "anagram", t = "nagaram"</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "rat", t = "car"</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length, t.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>s</code> and <code>t</code> consist of lowercase English letters.</li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> What if the inputs contain Unicode characters? How would you adapt your solution to such a case?</p>


---

# 🛍️ Valid-Anagram | Explained

## Approach 1 (Single-Pass Frequency Comparison)
### Intuition
Imagine you have two bags of letters, and you want to determine if they contain the same letters, regardless of order. One way to do this is to count the frequency of each letter in both bags and then compare the counts. If the counts are equal for all letters, the bags are anagrams of each other. This approach works because it takes into account the total frequency of each letter in both strings, ensuring that the letters and their counts are identical.

### Approach
The algorithm can be broken down into the following steps:
1. Check if the lengths of the two input strings are equal. If they are not, the strings cannot be anagrams of each other, so we return false.
2. Create a frequency array of size 26 (since there are 26 letters in the alphabet) to store the count of each letter in both strings.
3. Iterate through both strings simultaneously, incrementing the frequency count for each letter in the first string and decrementing the frequency count for each letter in the second string.
4. After iterating through both strings, check if all counts in the frequency array are zero. If any count is not zero, the strings are not anagrams, so we return false.
5. If all counts are zero, the strings are anagrams, so we return true.

### Detailed Code Analysis
The code starts by checking if the lengths of the two input strings `s` and `t` are equal. If they are not, it immediately returns false, as anagrams must have the same number of characters.
```java
if(s.length()!=t.length()) return false;
```
Next, it creates a frequency array `freq` of size 26 to store the count of each letter in both strings.
```java
int freq[] = new int[26];
```
The code then iterates through both strings simultaneously using a for loop. Inside the loop, it gets the current character from both strings using `s.charAt(i)` and `t.charAt(i)`, and increments the frequency count for the character from `s` and decrements the frequency count for the character from `t`. The indices for the frequency array are calculated by subtracting the ASCII value of 'a' from the ASCII value of the character. This works because the ASCII values for lowercase letters 'a' through 'z' are consecutive.
```java
for(int i=0;i<s.length();i++){
    char c1 = s.charAt(i);
    char c2 = t.charAt(i);
    freq[c1-'a']++;
    freq[c2-'a']--;
}
```
After iterating through both strings, the code checks if all counts in the frequency array are zero. If any count is not zero, it returns false, indicating that the strings are not anagrams.
```java
for(int i=0;i<26;i++){
    if(freq[i]!=0) return false;
}
```
If all counts are zero, the code returns true, indicating that the strings are anagrams.

### Code
```java
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int freq[] = new int[26];
        for(int i=0;i<s.length();i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            freq[c1-'a']++;
            freq[c2-'a']--;
        }
        for(int i=0;i<26;i++){
            if(freq[i]!=0) return false;
        }
        return true;
    }
}
```

### Complexity
- Time: O(n + m), where n and m are the lengths of the input strings `s` and `t`, respectively. However, since we are given that the strings are anagrams and therefore have the same length, the time complexity simplifies to O(n). The first loop iterates through both strings, and the second loop iterates through the frequency array, which has a constant size of 26.
- Space: O(1), which means the space used does not grow with the size of the input strings. The space complexity is constant because the frequency array has a fixed size of 26, regardless of the input string lengths.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some potential follow-up questions for this problem could be:
- How would you modify the solution to handle strings that contain uppercase letters or non-alphabetic characters?
  - One possible approach would be to convert the input strings to lowercase before processing them and to ignore non-alphabetic characters.
- How would you optimize the solution for very large input strings?
  - The existing solution has a time complexity of O(n) and a space complexity of O(1), which is already quite efficient. However, if the input strings are extremely large, you might consider using a more compact data structure, such as a `HashMap`, to store the character frequencies.