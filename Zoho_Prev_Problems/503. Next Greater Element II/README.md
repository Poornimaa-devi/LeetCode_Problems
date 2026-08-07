<h2><a href="https://leetcode.com/problems/next-greater-element-ii">503. Next Greater Element II</a></h2>

<p>Given a circular integer array <code>nums</code> (i.e., the next element of <code>nums[nums.length - 1]</code> is <code>nums[0]</code>), return <em>the <strong>next greater number</strong> for every element in</em> <code>nums</code>.</p>

<p>The <strong>next greater number</strong> of a number <code>x</code> is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return <code>-1</code> for this number.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,1]
<strong>Output:</strong> [2,-1,2]
Explanation: The first 1's next greater number is 2; 
The number 2 can't find next greater number. 
The second 1's next greater number needs to search circularly, which is also 2.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,3,4,3]
<strong>Output:</strong> [2,3,4,-1,4]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>


---

# 🛍️ Next-Greater-Element-II | Explained

## Approach 1: Monotonic Stack with Cyclic Array Iteration
### Intuition
The core idea behind this approach is to utilize a monotonic stack to keep track of the elements that we have seen so far and find their next greater element. We iterate through the array twice (using the modulo operator to create a cyclic effect) to ensure that we find the next greater element for each element, even if it appears later in the array. This approach works because the stack allows us to efficiently keep track of the elements that we have seen and find their next greater element as soon as we encounter it.

### Algorithm Visualized
```mermaid
graph LR;
    A[Stack] -->|push|> B[Index];
    B -->|pop|> C[Answer Array];
    C -->|update|> D[Index];
    D -->|next iteration|> B;
```
### Approach
The high-level logic flow of this approach is as follows:
1. Initialize an empty stack to store the indices of the elements in the array.
2. Initialize an answer array with the same length as the input array, filled with -1.
3. Iterate through the array twice (using the modulo operator to create a cyclic effect).
4. For each element, check if the stack is not empty and the current element is greater than the element at the top of the stack.
5. If the condition is met, pop the top element from the stack and update the answer array with the current element.
6. Push the current index to the stack if we are in the first iteration of the array.

### Detailed Code Analysis
Let's break down the code step by step:
- `Deque<Integer> stack = new ArrayDeque<>();`: We create an empty stack to store the indices of the elements in the array.
- `int n = nums.length;`: We store the length of the input array in a variable `n`.
- `int[] ans = new int[n];`: We create an answer array with the same length as the input array.
- `Arrays.fill(ans, -1);`: We fill the answer array with -1, which will be updated later with the next greater element.
- `for (int i = 0; i < 2 * n; i++)`: We iterate through the array twice using the modulo operator to create a cyclic effect.
- `int idx = i % n;`: We calculate the actual index in the array using the modulo operator.
- `while (!stack.isEmpty() && nums[idx] > nums[stack.peek()])`: We check if the stack is not empty and the current element is greater than the element at the top of the stack.
- `ans[stack.pop()] = nums[idx];`: If the condition is met, we pop the top element from the stack and update the answer array with the current element.
- `if (i < n) { stack.push(idx); }`: We push the current index to the stack if we are in the first iteration of the array.

### Code
```java
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();

        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < 2 * n; i++) {
            int idx = i % n;
            while (!stack.isEmpty() && nums[idx] > nums[stack.peek()]) {
                ans[stack.pop()] = nums[idx];
            }

            if (i < n) {
                stack.push(idx);
            }
        }

        return ans;
    }
}
```
### Complexity
- **Time:** The time complexity of this solution is O(n), where n is the length of the input array. This is because we iterate through the array twice, and the stack operations (push and pop) take constant time.
- **Space:** The space complexity of this solution is O(n), where n is the length of the input array. This is because we use a stack to store the indices of the elements in the array, and in the worst case, the stack can grow up to the size of the input array.

## 🕵️‍♂️ Follow-up Questions (Optional)
1. What if the input array is empty? The solution will return an empty array.
2. What if the input array contains duplicate elements? The solution will still find the next greater element for each element, even if it's a duplicate.