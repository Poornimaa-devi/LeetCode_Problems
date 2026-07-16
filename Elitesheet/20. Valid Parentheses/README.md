<h2><a href="https://leetcode.com/problems/valid-parentheses">20. Valid Parentheses</a></h2>

<p>Given a string <code>s</code> containing just the characters <code>'('</code>, <code>')'</code>, <code>'{'</code>, <code>'}'</code>, <code>'['</code> and <code>']'</code>, determine if the input string is valid.</p>

<p>An input string is valid if:</p>

<ol>
	<li>Open brackets must be closed by the same type of brackets.</li>
	<li>Open brackets must be closed in the correct order.</li>
	<li>Every close bracket has a corresponding open bracket of the same type.</li>
</ol>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "()"</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "()[]{}"</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "(]"</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>
</div>

<p><strong class="example">Example 4:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "([])"</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>
</div>

<p><strong class="example">Example 5:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = "([)]"</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>4</sup></code></li>
	<li><code>s</code> consists of parentheses only <code>'()[]{}'</code>.</li>
</ul>


---

# 🛍️ Valid-Parentheses | Explained

## Approach 1 (Stack-Based)
### Intuition
The core idea behind this approach is to utilize a stack data structure to keep track of the opening parentheses encountered in the input string. This approach works because a stack follows the Last-In-First-Out (LIFO) principle, which is similar to how we match closing parentheses with the most recently encountered opening parenthesis. Think of it like a stack of plates: when you add a new plate (opening parenthesis), it goes on top, and when you remove a plate (closing parenthesis), it's the one that was added most recently.

### Approach
The algorithmic breakdown can be summarized as follows:
1. Initialize an empty stack to store the opening parentheses.
2. Iterate through the input string character by character.
3. If the current character is an opening parenthesis, push it onto the stack.
4. If the current character is a closing parenthesis, check if the stack is empty. If it is, return false because there's no matching opening parenthesis. Otherwise, pop the top element from the stack and verify if it matches the current closing parenthesis. If it doesn't match, return false.
5. After iterating through the entire string, check if the stack is empty. If it's not, return false because there are unmatched opening parentheses. Otherwise, return true, indicating that all parentheses are matched correctly.

### Detailed Code Analysis
Let's dive into the code block:
- `Stack<Character> stack = new Stack<>();`: This line initializes an empty stack to store the opening parentheses. The `Stack` class is chosen because it provides an efficient way to implement the LIFO principle.
- `for (char c : s.toCharArray())`: This loop iterates through the input string `s` character by character. The `toCharArray()` method converts the string into a character array, allowing us to use a for-each loop.
- `if (c == '(' || c == '{' || c == '[')`: This conditional statement checks if the current character is an opening parenthesis. If it is, the code inside the if block is executed.
- `stack.push(c);`: This line pushes the opening parenthesis onto the stack.
- `else`: This block is executed when the current character is a closing parenthesis.
- `if (stack.isEmpty())`: This conditional statement checks if the stack is empty. If it is, the function immediately returns false because there's no matching opening parenthesis for the current closing parenthesis.
- `char top = stack.pop();`: This line pops the top element from the stack, which represents the most recently encountered opening parenthesis.
- `if (c == ')' && top != '(' || c == '}' && top != '{' || c == ']' && top != '[')`: This conditional statement checks if the popped opening parenthesis matches the current closing parenthesis. If it doesn't match, the function returns false.
- `return stack.isEmpty();`: After iterating through the entire string, this line checks if the stack is empty. If it's not, the function returns false because there are unmatched opening parentheses. Otherwise, it returns true, indicating that all parentheses are matched correctly.

### Code
```java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                char top = stack.pop();
                if (c == ')' && top != '(' || c == '}' && top != '{' || c == ']' && top != '[')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
```

### Complexity
- Time: The time complexity of this solution is O(n), where n is the length of the input string. This is because we're iterating through the string once, and the push and pop operations on the stack take constant time.
- Space: The space complexity is O(n) as well, because in the worst-case scenario (when the input string consists of all opening parentheses), the stack will store n elements.

## 🕵️‍♂️ Follow-up Questions (Optional)
Some common follow-up questions for this pattern include:
1. How would you optimize the solution for very large input strings?
   Answer: To optimize the solution, you could consider using a more efficient data structure than the `Stack` class, such as an array-based stack implementation. Additionally, you could consider using a more efficient algorithm, such as one that uses a single pass through the string and doesn't require the overhead of the `toCharArray()` method.
2. How would you extend the solution to support additional types of parentheses, such as angle brackets (<>)?
   Answer: To extend the solution, you would need to modify the conditional statements to check for the additional types of parentheses and update the matching logic accordingly. For example, you would need to add checks for '<' and '>' characters and update the matching logic to handle these new types of parentheses.