<h2><a href="https://leetcode.com/problems/permutation-in-string">567. Permutation in String</a></h2>

<p>Given two strings <code>s1</code> and <code>s2</code>, return <code>true</code> if <code>s2</code> contains a <span data-keyword="permutation-string" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_1l_" data-state="closed" class="">permutation</button></span> of <code>s1</code>, or <code>false</code> otherwise.</p>

<p>In other words, return <code>true</code> if one of <code>s1</code>'s permutations is the substring of <code>s2</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s1 = "ab", s2 = "eidbaooo"
<strong>Output:</strong> true
<strong>Explanation:</strong> s2 contains one permutation of s1 ("ba").
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s1 = "ab", s2 = "eidboaoo"
<strong>Output:</strong> false
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s1.length, s2.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s1</code> and <code>s2</code> consist of lowercase English letters.</li>
</ul>


---

# 🛍️ Permutation-in-String | Explained

## Approach 1: Sliding Window with Frequency Counting
### Intuition
The core idea of this approach is to treat the characters in the strings as items in a bucket and count their frequencies. By comparing the frequency counts of the characters in the sliding window with the target string, we can efficiently determine if a permutation exists. This approach works by leveraging the fact that if two strings are permutations of each other, they must have the same character frequencies.

### Algorithm Visualized
No diagram is necessary for this explanation, as the algorithmic logic is straightforward.

### Approach
The approach involves the following steps:
- Create two frequency arrays to count the occurrences of each character in the strings.
- Initialize the frequency arrays by counting the characters in the first window of the larger string.
- Compare the frequency arrays to check for a permutation.
- If no permutation is found, slide the window to the right and update the frequency counts accordingly.
- Repeat the comparison and sliding process until the end of the larger string is reached.

### Detailed Code Analysis
The code begins by checking if the length of the smaller string `s1` is greater than the length of the larger string `s2`. If so, it immediately returns `false`, as a permutation of `s1` cannot exist within `s2`.

```java
if(s1.length()>s2.length()) return false;
```
It then initializes two integer arrays `freq1` and `freq2` to store the frequency counts of the characters in `s1` and the current window of `s2`, respectively.

```java
int freq1[] = new int[26];
int freq2[] = new int[26];
```
The code then populates the `freq1` and `freq2` arrays by counting the characters in `s1` and the first window of `s2`.

```java
for(int i=0;i<s1.length();i++){
    freq1[s1.charAt(i)-'a']++;
    freq2[s2.charAt(i)-'a']++;
}
```
The expression `s1.charAt(i)-'a'` calculates the index of the character in the frequency array by subtracting the ASCII value of 'a' from the ASCII value of the character. This works because the ASCII values of the lowercase letters 'a' to 'z' are contiguous.

The code then checks if the frequency arrays `freq1` and `freq2` are equal using the `Arrays.equals` method. If they are equal, it means that the characters in the first window of `s2` form a permutation of `s1`, and the function returns `true`.

```java
if(Arrays.equals(freq1,freq2)) return true;
```
If the frequency arrays are not equal, the code enters a loop that slides the window to the right and updates the frequency counts.

```java
for(int right = s1.length();right<s2.length();right++){
    int left = right - s1.length();
    freq2[s2.charAt(left)-'a']--;
    freq2[s2.charAt(right)-'a']++;
    if(Arrays.equals(freq1,freq2)) return true;
}
```
In each iteration of the loop, the code decrements the frequency count of the character that is no longer in the window and increments the frequency count of the new character that has entered the window.

Finally, if the loop completes without finding a permutation, the function returns `false`.

```java
return false;
```
### Code
```java
public boolean checkInclusion(String s1, String s2) {
    if(s1.length()>s2.length()) return false;
    int freq1[] = new int[26];
    int freq2[] = new int[26];
    for(int i=0;i<s1.length();i++){
        freq1[s1.charAt(i)-'a']++;
        freq2[s2.charAt(i)-'a']++;
    }
    if(Arrays.equals(freq1,freq2)) return true;
    for(int right = s1.length();right<s2.length();right++){
        int left = right - s1.length();
        freq2[s2.charAt(left)-'a']--;
        freq2[s2.charAt(right)-'a']++;
        if(Arrays.equals(freq1,freq2)) return true;
    }
    return false;
}
```
### Complexity
- **Time:** The time complexity of this approach is O(n), where n is the length of the larger string `s2`. The reason is that we are scanning the string `s2` once, and the operations inside the loop (frequency count updates and comparisons) take constant time.
- **Space:** The space complexity is O(1), which means the space required does not grow with the size of the input. This is because we are using a fixed-size array of size 26 to store the frequency counts, regardless of the length of the input strings.