<h2><a href="https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses">1249. Minimum Remove to Make Valid Parentheses</a></h2>

<p>Given a string <font face="monospace">s</font> of <code>'('</code> , <code>')'</code> and lowercase English characters.</p>

<p>Your task is to remove the minimum number of parentheses ( <code>'('</code> or <code>')'</code>, in any positions ) so that the resulting <em>parentheses string</em> is valid and return <strong>any</strong> valid string.</p>

<p>Formally, a <em>parentheses string</em> is valid if and only if:</p>

<ul>
	<li>It is the empty string, contains only lowercase characters, or</li>
	<li>It can be written as <code>AB</code> (<code>A</code> concatenated with <code>B</code>), where <code>A</code> and <code>B</code> are valid strings, or</li>
	<li>It can be written as <code>(A)</code>, where <code>A</code> is a valid string.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> s = "lee(t(c)o)de)"
<strong>Output:</strong> "lee(t(c)o)de"
<strong>Explanation:</strong> "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> s = "a)b(c)d"
<strong>Output:</strong> "ab(c)d"
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> s = "))(("
<strong>Output:</strong> ""
<strong>Explanation:</strong> An empty string is also valid.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s[i]</code> is either&nbsp;<code>'('</code> , <code>')'</code>, or lowercase English letter.</li>
</ul>


---

# 🛍️ Minimum-Remove-to-Make-Valid-Parentheses | Explained

## Approach 1: Stack-Based Approach
### Intuition
The intuition behind this approach is to mimic the process of parsing and validating a sequence of parentheses. Imagine a stack of plates where each opening parenthesis represents a plate being added to the stack, and each closing parenthesis represents a plate being removed from the stack. If we encounter a closing parenthesis when the stack is empty, it means there's no matching opening parenthesis, so we mark it for removal. Similarly, if there are opening parentheses left in the stack after processing the entire string, we mark them for removal as well. This approach ensures that the resulting string has a valid sequence of parentheses.

### Approach
The algorithm can be broken down into two main steps:
1. Identify and mark the indices of parentheses that need to be removed to make the string valid.
2. Construct the resulting string by excluding the marked indices.

### Detailed Code Analysis
Let's dive into the code:
- We start by initializing an empty stack `st` to keep track of the indices of opening parentheses and a boolean array `remove` to mark the indices of parentheses that need to be removed.
- We iterate through the input string `s`. For each character `ch`, we check if it's an opening parenthesis. If it is, we push its index onto the stack.
- If `ch` is a closing parenthesis, we check if the stack is empty. If it's not, we pop the index from the stack (effectively matching the opening parenthesis with the current closing parenthesis). If the stack is empty, it means there's no matching opening parenthesis, so we mark the current index for removal by setting `remove[i]` to `true`.
- After iterating through the entire string, we pop any remaining indices from the stack and mark them for removal, as these opening parentheses don't have matching closing parentheses.
- Finally, we construct the resulting string by iterating through the input string again and appending characters to the `result` StringBuilder only if their indices are not marked for removal.

### Code
```java
class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        boolean remove[] = new boolean[s.length()];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='(') st.push(i);
            else if(ch==')'){
                if(!st.isEmpty()) st.pop();
                else remove[i]=true;
            }
        }
        while(!st.isEmpty()){
            remove[st.pop()]=true;
        }
        StringBuilder result = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(remove[i]==false){
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }
}
```
### Complexity
- **Time:** The time complexity is O(n), where n is the length of the input string `s`. This is because we're making two passes through the string: one to identify and mark the indices of parentheses that need to be removed, and another to construct the resulting string.
- **Space:** The space complexity is also O(n), as in the worst-case scenario, we might need to store the indices of all opening parentheses in the stack, and we're using a boolean array of size n to keep track of the indices of parentheses that need to be removed.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. **How would you handle the case where the input string is null or empty?** 
   - You can add a simple check at the beginning of the function to return an empty string or throw an exception, depending on the requirements.
2. **Can you optimize the solution to use less space?** 
   - The current solution uses a stack and a boolean array, both of which have a space complexity of O(n). While we can't reduce the space complexity below O(n) without changing the approach, we could consider using a single data structure, such as a stack that stores both the indices and a boolean flag, but this would likely make the code more complex and less efficient.