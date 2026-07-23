<h2><a href="https://leetcode.com/problems/vowels-game-in-a-string">3227. Vowels Game in a String</a></h2>

<p>Alice and Bob are playing a game on a string.</p>

<p>You are given a string <code>s</code>, Alice and Bob will take turns playing the following game where Alice starts <strong>first</strong>:</p>

<ul>
	<li>On Alice's turn, she has to remove any <strong>non-empty</strong> <span data-keyword="substring" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_1m_" data-state="closed" class="">substring</button></span> from <code>s</code> that contains an <strong>odd</strong> number of vowels.</li>
	<li>On Bob's turn, he has to remove any <strong>non-empty</strong> <span data-keyword="substring" class=" cursor-pointer relative text-dark-blue-s text-sm"><button type="button" aria-haspopup="dialog" aria-expanded="false" aria-controls="radix-_r_1n_" data-state="closed" class="">substring</button></span> from <code>s</code> that contains an <strong>even</strong> number of vowels.</li>
</ul>

<p>The first player who cannot make a move on their turn loses the game. We assume that both Alice and Bob play <strong>optimally</strong>.</p>

<p>Return <code>true</code> if Alice wins the game, and <code>false</code> otherwise.</p>

<p>The English vowels are: <code>a</code>, <code>e</code>, <code>i</code>, <code>o</code>, and <code>u</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "leetcoder"</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

<p><strong>Explanation:</strong><br>
Alice can win the game as follows:</p>

<ul>
	<li>Alice plays first, she can delete the underlined substring in <code>s = "<u><strong>leetco</strong></u>der"</code> which contains 3 vowels. The resulting string is <code>s = "der"</code>.</li>
	<li>Bob plays second, he can delete the underlined substring in <code>s = "<u><strong>d</strong></u>er"</code> which contains 0 vowels. The resulting string is <code>s = "er"</code>.</li>
	<li>Alice plays third, she can delete the whole string <code>s = "<strong><u>er</u></strong>"</code> which contains 1 vowel.</li>
	<li>Bob plays fourth, since the string is empty, there is no valid play for Bob. So Alice wins the game.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "bbcd"</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>

<p><strong>Explanation:</strong><br>
There is no valid play for Alice in her first turn, so Alice loses the game.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s</code> consists only of lowercase English letters.</li>
</ul>


---

# 🛍️ Vowels-Game-in-a-String | Explained
## Approach 1: Simple Vowel Check
### Intuition
The core idea behind this approach is to iterate through each character in the given string and check if it is a vowel. This approach works by essentially treating the string as a sequence of characters and examining each one individually, similar to how a person would scan a word in a book.

### Algorithm Visualized
No Mermaid.js diagram is provided for this approach, as the logic is straightforward and simple.

### Approach
The algorithm works by iterating through the string character by character and checking for vowels. The first time it encounters a vowel, it immediately returns true, indicating that Alice wins. If it iterates through the entire string without finding a vowel, it returns false.

### Detailed Code Analysis
Let's break down the code line by line:
- Line 1: `class Solution {` declares a new class named `Solution`.
- Line 2: `public boolean doesAliceWin(String s) {` defines a public method named `doesAliceWin` that takes a `String` parameter `s` and returns a `boolean` value.
- Line 3: `for(char ch : s.toCharArray()){` iterates through each character in the string `s` using an enhanced for loop. The `toCharArray()` method converts the string into a character array, allowing for iteration.
- Line 4: `if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){` checks if the current character `ch` is a vowel (either 'a', 'e', 'i', 'o', or 'u'). This condition will be true if `ch` is any of these vowels.
- Line 5: `return true;` immediately returns `true` as soon as a vowel is found, indicating that Alice wins.
- Line 7: `return false;` returns `false` if the loop completes without finding any vowels, indicating that Alice does not win.

### Code
```java
class Solution {
    public boolean doesAliceWin(String s) {
        for(char ch : s.toCharArray()){
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                return true;
            }
        }
        return false;
    }
}
```
### Complexity
- **Time:** The time complexity of this approach is O(n), where n is the length of the input string. This is because in the worst-case scenario, the algorithm must iterate through every character in the string once.
- **Space:** The space complexity is O(n), where n is the length of the input string. This is because the `toCharArray()` method creates a new character array of the same length as the input string. 

## 🕵️‍♂️ Follow-up Questions (Optional)
Some potential follow-up questions for this pattern include:
1. How would you modify the code to handle uppercase vowels as well?
   Answer: You would add checks for the uppercase counterparts of the vowels, 'A', 'E', 'I', 'O', 'U', in the `if` condition.

2. Can you improve the time complexity of the solution?
   Answer: The current time complexity is already linear (O(n)), which is the best you can achieve for this problem since you must examine every character at least once to determine the presence of a vowel.