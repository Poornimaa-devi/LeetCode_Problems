<h2><a href="https://leetcode.com/problems/next-greater-element-iv">2454. Next Greater Element IV</a></h2>

<p>You are given a <strong>0-indexed</strong> array of non-negative integers <code>nums</code>. For each integer in <code>nums</code>, you must find its respective <strong>second greater</strong> integer.</p>

<p>The <strong>second greater</strong> integer of <code>nums[i]</code> is <code>nums[j]</code> such that:</p>

<ul>
	<li><code>j &gt; i</code></li>
	<li><code>nums[j] &gt; nums[i]</code></li>
	<li>There exists <strong>exactly one</strong> index <code>k</code> such that <code>nums[k] &gt; nums[i]</code> and <code>i &lt; k &lt; j</code>.</li>
</ul>

<p>If there is no such <code>nums[j]</code>, the second greater integer is considered to be <code>-1</code>.</p>

<ul>
	<li>For example, in the array <code>[1, 2, 4, 3]</code>, the second greater integer of <code>1</code> is <code>4</code>, <code>2</code> is <code>3</code>,&nbsp;and that of <code>3</code> and <code>4</code> is <code>-1</code>.</li>
</ul>

<p>Return<em> an integer array </em><code>answer</code><em>, where </em><code>answer[i]</code><em> is the second greater integer of </em><code>nums[i]</code><em>.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [2,4,0,9,6]
<strong>Output:</strong> [9,6,6,-1,-1]
<strong>Explanation:</strong>
0th index: 4 is the first integer greater than 2, and 9 is the second integer greater than 2, to the right of 2.
1st index: 9 is the first, and 6 is the second integer greater than 4, to the right of 4.
2nd index: 9 is the first, and 6 is the second integer greater than 0, to the right of 0.
3rd index: There is no integer greater than 9 to its right, so the second greater integer is considered to be -1.
4th index: There is no integer greater than 6 to its right, so the second greater integer is considered to be -1.
Thus, we return [9,6,6,-1,-1].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [3,3]
<strong>Output:</strong> [-1,-1]
<strong>Explanation:</strong>
We return [-1,-1] since neither integer has any integer greater than it.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>


---

# 🛍️ Next-Greater-Element-IV | Explained

## Approach 1: Stack-Based Solution
### Intuition
The intuition behind this approach is to leverage two stacks to keep track of elements that have not yet found their next greater element and the next greater element for the elements in the first stack. This approach works by using the first stack to store indices of elements from the input array and the second stack to store indices of elements that have already found their first greater element but not their second greater element. When a new element is encountered, it is used to update the second greater element for the elements in the second stack and the first greater element for the elements in the first stack.

### Algorithm Visualized
```mermaid
graph LR;
    A[Input Array] -->|iterate through|> B[Stack 1];
    B -->|push/pop based on current element|> C[Stack 2];
    C -->|update result array|> D[Result Array];
    D -->|return|> E[Final Result];
```

### Approach
The algorithm starts by initializing two stacks, `st1` and `st2`, and an array `res` to store the second greater element for each element in the input array. It then iterates through the input array. For each element, it pops elements from `st2` that are smaller than the current element and updates the `res` array with the current element as the second greater element. It then pops elements from `st1` that are smaller than the current element and pushes them onto `st2`. Finally, it pushes the current index onto `st1`. This process continues until all elements in the input array have been processed.

### Detailed Code Analysis
The code initializes the necessary variables and data structures:
- `n` is the length of the input array `nums`.
- `st1` and `st2` are the two stacks used to keep track of elements.
- `t1` and `t2` are the top indices of `st1` and `st2`, respectively.
- `res` is the array to store the second greater element for each element in the input array.
- `temp` is a temporary array used to transfer elements from `st1` to `st2`.
- `top` is the top index of the `temp` array.

The code then iterates through the input array. For each element:
- It checks if there are elements in `st2` that are smaller than the current element. If so, it updates the `res` array with the current element as the second greater element and pops the element from `st2`.
- It checks if there are elements in `st1` that are smaller than the current element. If so, it pops the element from `st1` and pushes it onto `st2`.
- It pushes the current index onto `st1`.

### Code
```java
class Solution {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int st1[] = new int[n];
        int st2[] = new int[n];
        int t1 = -1;
        int t2 = -1;
        int res[] = new int[n];
        Arrays.fill(res, -1);
        int temp[] = new int[n];
        int top = -1;
        for(int i = 0; i < n; i++) {
            int curr = nums[i];
            while(t2 != -1 && nums[st2[t2]] < curr) {
                res[st2[t2--]] = curr;
            }
            while(t1 != -1 && nums[st1[t1]] < curr) {
                temp[++top] = st1[t1--];
            }
            while(top != -1) {
                st2[++t2] = temp[top--];
            }
            st1[++t1] = i;
        }
        return res;
    }
}
```

### Complexity
- **Time:** The time complexity is O(n), where n is the length of the input array. This is because each element in the input array is pushed and popped from the stacks at most once.
- **Space:** The space complexity is O(n), where n is the length of the input array. This is because in the worst case, the stacks and the temporary array can store up to n elements.